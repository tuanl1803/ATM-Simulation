package com.mitrais.studycase.atm.controllers;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.models.Transaction;
import com.mitrais.studycase.atm.services.TransactionServiceImpl;
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
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@PropertySource("classpath:message.properties")
@RequestMapping("")
public class ViewTransactionController {

	@Autowired
	private Environment env;

	@Autowired
	private TransactionServiceImpl transactionService;

	@Value("${app.viewn.transaction}")
	private Integer nTransaction;

	private static List<Map<String, String>> formattedList;

	@GetMapping(path =  "/view-transaction")
	public ModelAndView viewTransaction(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		ModelAndView view = new ModelAndView();
		try {
			Account account = (Account) request.getSession().getAttribute("account");
			if (account == null){
				view.setViewName("redirect:/");
			} else {
				formattedList = new ArrayList<>();
				List<Transaction> listTransaction = transactionService.findNTransaction(account.getAccountNumber(),
						nTransaction);
				listTransaction.forEach(transaction -> {
					Map<String, String> formatted = new HashMap<String, String>();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
					formatted.put("date", dateFormat.format(transaction.getDate()));
					formatted.put("type", transaction.getType().toString());
					DecimalFormat formatter = new DecimalFormat("#,###.00");
					formatted.put("amount", formatter.format(transaction.getAmount()));
					if (transaction.getDestinationAccount() != null)
						formatted.put("destinationAccount", transaction.getDestinationAccount().getAccountNumber());
					formatted.put("reference", transaction.getReference());
					formattedList.add(formatted);
				});
				view.addObject("list", formattedList);
				view.setViewName("transaction/transaction");
			}

		} catch (Exception e) {
			request.getSession().invalidate();
			view = new ModelAndView("redirect:/");
			redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
		}
		return view;
	}

}
