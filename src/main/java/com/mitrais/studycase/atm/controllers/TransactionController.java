package com.mitrais.studycase.atm.controllers;

import com.mitrais.studycase.atm.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;

@Controller
@PropertySource("classpath:message.properties")
@RequestMapping("")
public class TransactionController {

    @Autowired
    private Environment env;

    @Value("${app.viewn.transaction}")
    private String nTransaction;

    @GetMapping(path = "/transaction")
    public ModelAndView inputAccountNumber(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account == null)
                return new ModelAndView("redirect:/");
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            view.addObject("accountNumber", account.getAccountNumber());
            view.addObject("balance", formatter.format(account.getBalance()));
            view.addObject("nTransaction", nTransaction);
            view.setViewName("transaction/index");
        } catch (Exception e) {
            request.getSession().invalidate();
            view = new ModelAndView("redirect:/");
            redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
        }
        return view;
    }

    @GetMapping(path = "/logout")
    public ModelAndView logout(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        request.getSession().invalidate();
        return new ModelAndView("redirect:/");
    }
}
