package com.mitrais.studycase.atm.controllers;

import com.mitrais.studycase.atm.services.WithdrawServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/withdraw")
public class WithdrawController {
    @Autowired
    WithdrawServiceImpl withdrawService;

    @RequestMapping(value = "/withdrawAmount", method = RequestMethod.GET)
    public String withdrawAmount(Model model){
//        withdrawService.withdrawAmount(account, amount);
        return "success";
    }
}
