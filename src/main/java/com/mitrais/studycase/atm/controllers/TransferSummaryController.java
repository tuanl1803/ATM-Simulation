package com.mitrais.studycase.atm.controllers;

import com.mitrais.studycase.atm.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;

@Controller
@PropertySource("classpath:message.properties")
@RequestMapping("")
public class TransferSummaryController {

	@Autowired
	private Environment env;

	@GetMapping(path =  "/transfer-summary")
	public ModelAndView transferSummary(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		ModelAndView view = new ModelAndView();
		try {
			Account account = (Account) request.getSession().getAttribute("account");
			if (account == null)
				return new ModelAndView("redirect:/");
			view.setViewName("transfer/summary");
		} catch (Exception e) {
			request.getSession().invalidate();
			view = new ModelAndView("redirect:/");
			redirectAttributes.addFlashAttribute("message", env.getProperty("app.unknown.error"));
		}
		return view;
	}

}
