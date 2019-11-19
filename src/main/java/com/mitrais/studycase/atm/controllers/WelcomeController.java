package com.mitrais.studycase.atm.controllers;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
@PropertySource("classpath:message.properties")
@RequestMapping("")
public class WelcomeController {

    @Autowired
    private Environment env;

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping(value = "/")
    public ModelAndView inputAccountNumber(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account != null)
                return new ModelAndView("redirect:/transaction");
            view.setViewName("welcome/inputAccountNumber");
        } catch (Exception e) {
            view = new ModelAndView("redirect:/");
            redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
        }
        return view;
    }

    @PostMapping(path = "/upload")
    public ModelAndView upload(HttpServletRequest request, RedirectAttributes redirectAttributes,
                               @RequestParam("file") MultipartFile file) {
        List<Account> inputList = new ArrayList<>();
        try {
            InputStream inputFS = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().skip(1).map(mapToItem).parallel().collect(Collectors.toList());
            inputList = inputList.stream().filter(distinctByKey(Account::getAccountNumber))
                    .collect(Collectors.toList());
            inputList.parallelStream().forEach(account -> {
                accountService.saveAccount(account);
            });
            redirectAttributes.addFlashAttribute("notif", env.getProperty("app.upload.success"));
            return new ModelAndView("redirect:/");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
            return new ModelAndView("redirect:/");
        }
    }

    @GetMapping(path="/pin")
    public ModelAndView inputPin(HttpServletRequest request, RedirectAttributes redirectAttributes,
                                 @RequestParam(value = "an", required = true) String accountNumber) {
        ModelAndView view = new ModelAndView();
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account != null)
                return new ModelAndView("redirect:/transaction");
            boolean stoper = false;
            String message = "";
            if (accountNumber.length() != 6) {
                message += env.getProperty("app.accountnumber.size");
                stoper = true;
            }
            if (!accountNumber.matches("[0-9]+")) {
                message += env.getProperty("app.accountnumber.number");
                stoper = true;
            }
            if (stoper) {
                view = new ModelAndView("redirect:/");
                redirectAttributes.addFlashAttribute("message", message);
            } else {
                view.addObject("accountNumber", accountNumber);
                view.setViewName("welcome/inputPin");
            }
        } catch (Exception e) {
            view = new ModelAndView("redirect:/");
            redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
        }
        return view;
    }

    @PostMapping(path = "/login")
    public ModelAndView login(HttpServletRequest request, RedirectAttributes redirectAttributes,
                              @RequestParam(value = "accountNumber", required = true) String accountNumber,
                              @RequestParam(value = "pin", required = true) String pin) {
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account != null)
                return new ModelAndView("redirect:/transaction");
            boolean stoper = false;
            String message = "";
            if (pin.length() != 6) {
                message += env.getProperty("app.pin.size");
                stoper = true;
            }
            if (!pin.matches("[0-9]+")) {
                message += env.getProperty("app.pin.number");
                stoper = true;
            }
            if (stoper) {
                redirectAttributes.addFlashAttribute("message", message);
                return new ModelAndView("redirect:/pin?an=" + accountNumber);
            }
            List<Account> listAccount = accountService.findByAccountNumberAndPin(accountNumber, pin);
            if (!listAccount.isEmpty()) {
                message += env.getProperty("app.login.invalid");
                redirectAttributes.addFlashAttribute("message", message);
                return new ModelAndView("redirect:/");

            } else {
                request.getSession().setAttribute("account", listAccount.get(0));
                return new ModelAndView("redirect:/transaction");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
            return new ModelAndView("redirect:/");
        }
    }

    private Function<String, Account> mapToItem = (line) -> {
        String[] p = line.split(";");// a CSV has comma separated lines
        Account item = new Account();
        item.setName(p[0]);
        item.setPin(p[1]);
        item.setBalance(Double.valueOf(p[2]));
        item.setAccountNumber(p[3]);
        return item;
    };

    private <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
