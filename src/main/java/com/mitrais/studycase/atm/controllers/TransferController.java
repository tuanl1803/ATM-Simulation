package com.mitrais.studycase.atm.controllers;

import com.mitrais.studycase.atm.constants.TransactionType;
import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.models.Transaction;
import com.mitrais.studycase.atm.services.AccountServiceImpl;
import com.mitrais.studycase.atm.services.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Controller
@PropertySource("classpath:message.properties")
@RequestMapping("")
public class TransferController {

	@Autowired
	private Environment env;

	@Autowired
	private AccountServiceImpl accountService;

	@Autowired
	private TransactionServiceImpl transactionService;

	@GetMapping(path = "/transfer-destination")
	public ModelAndView transferDestination(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		ModelAndView view = new ModelAndView();
		try {
			Account account = (Account) request.getSession().getAttribute("account");
			if (account == null){
				view.setViewName("redirect:/");
			} else {
				view.setViewName("transfer/destination");
			}
		} catch (Exception e) {
			request.getSession().invalidate();
			view.setViewName("redirect:/");
			redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
		}
		return view;
	}

	@GetMapping(path ="/transfer-amount" )
	public ModelAndView transferAmount(HttpServletRequest request, RedirectAttributes redirectAttributes,
                                       @RequestParam(value = "destination", required = true) String destination) {
		ModelAndView view = new ModelAndView();
		try {
			Account account = (Account) request.getSession().getAttribute("account");
			if (account == null)
				return new ModelAndView("redirect:/");
			String message = "";
			boolean stoper = false;
			if (!destination.matches("[0-9]+")) {
				message += env.getProperty("app.invalid.account");
				stoper = true;
			}

			List<Account> listAccount = accountService.findByAccountNumber(destination);
			if (listAccount.size() <= 0) {
				message += env.getProperty("app.invalid.account");
				stoper = true;
			}

			if (stoper) {
				view = new ModelAndView("redirect:/destination");
				redirectAttributes.addFlashAttribute("message", message);
			} else {
				view.addObject("destination", destination);
				view.setViewName("transfer/amount");
			}
		} catch (Exception e) {
			request.getSession().invalidate();
			view = new ModelAndView("redirect:/");
			redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
		}
		return view;
	}

	@GetMapping(path = "/transfer-confirm")
	public ModelAndView transferConfirm(HttpServletRequest request, RedirectAttributes redirectAttributes,
                                        @RequestParam(value = "destination", required = true) String destination,
                                        @RequestParam(value = "amount", required = true) String amount) {
		ModelAndView view = new ModelAndView();
		try {
			Account account = (Account) request.getSession().getAttribute("account");
			if (account == null)
				return new ModelAndView("redirect:/");
			String message = "";
			boolean stoper = false;
			if (!amount.matches("[0-9]+")) {
				message += env.getProperty("app.amount.number");
				stoper = true;
			} else {
				if (Long.valueOf(amount) < 1) {
					message += env.getProperty("app.amount.mintransfer");
					stoper = true;
				}
				if (Long.valueOf(amount) > 1000) {
					message += env.getProperty("app.amount.maxtransfer");
					stoper = true;
				}
				if (Long.valueOf(amount) > account.getBalance()) {
					message += env.getProperty("app.amount.insufficient") + account.getBalance() + "<br>";
					stoper = true;
				}
			}

			if (stoper) {
				view = new ModelAndView("redirect:/transfer-amount");
				redirectAttributes.addFlashAttribute("message", message);
			} else {
				view.addObject("accountNumber", account.getAccountNumber());
				view.addObject("destination", destination);
				DecimalFormat formatter = new DecimalFormat("#,###.00");
				view.addObject("amount", formatter.format(Double.valueOf(amount)));
				view.addObject("reference", generateTransferId());
				view.setViewName("transfer/confirm");
			}
		} catch (Exception e) {
			request.getSession().invalidate();
			view = new ModelAndView("redirect:/");
			redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
		}
		return view;
	}

	@PostMapping(path = "/transfer")
	public ModelAndView transfer(HttpServletRequest request, RedirectAttributes redirectAttributes,
                              @RequestParam(value = "destination", required = true) String destination,
                              @RequestParam(value = "reference", required = true) String reference,
                              @RequestParam(value = "amount", required = true) String amount) {
		ModelAndView view = new ModelAndView();
		try {
			Account account = (Account) request.getSession().getAttribute("account");
			if (account == null)
				return new ModelAndView("redirect:/");
			String message = "";
			boolean stoper = false;
			if (!destination.matches("[0-9]+")) {
				message += env.getProperty("app.invalid.account");
				stoper = true;
			}

			List<Account> listAccount = accountService.findByAccountNumber(destination);
			if (listAccount.size() <= 0) {
				message += env.getProperty("app.invalid.account");
				stoper = true;
			}
			amount = amount.replace(".00", "");
			if (!amount.matches("[0-9]+")) {
				message += env.getProperty("app.amount.number");
				stoper = true;
			} else {
				if (Long.valueOf(amount) < 1) {
					message += env.getProperty("app.amount.mintransfer");
					stoper = true;
				}
				if (Long.valueOf(amount) > 1000) {
					message += env.getProperty("app.amount.maxtransfer");
					stoper = true;
				}
				if (Long.valueOf(amount) > account.getBalance()) {
					message += env.getProperty("app.amount.insufficient") + account.getBalance() + "<br>";
					stoper = true;
				}
			}

			if (stoper) {
				view = new ModelAndView("redirect:/transaction");
				redirectAttributes.addFlashAttribute("message", message);
			} else {
				Account accDest = accountService.findByAccountNumber(destination).get(0);
				account.setBalance(account.getBalance() - Double.valueOf(amount));
				accDest.setBalance(accDest.getBalance() + Double.valueOf(amount));
				Transaction transaction = new Transaction(TransactionType.TRANSFER, account, Double.valueOf(amount),
						new Date(), accDest, reference);
				account = accountService.saveAccount(account);
				accDest = accountService.saveAccount(accDest);
				transactionService.saveTransaction(transaction);
				request.getSession().setAttribute("account", account);
				redirectAttributes.addFlashAttribute("destination", destination);
				redirectAttributes.addFlashAttribute("amount", amount);
				redirectAttributes.addFlashAttribute("reference", reference);
				redirectAttributes.addFlashAttribute("balance", account.getBalance());
				view = new ModelAndView("redirect:/transfer-summary");
			}
		} catch (Exception e) {
			view = new ModelAndView("redirect:/");
			redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
		}
		return view;
	}

	private String generateTransferId() {
		String NUMBER = "0123456789";
		String DATA_FOR_RANDOM_STRING = NUMBER;
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(6);
		for (int i = 0; i < 6; i++) {
			int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
			sb.append(rndChar);
		}
		return sb.toString();
	}
}
