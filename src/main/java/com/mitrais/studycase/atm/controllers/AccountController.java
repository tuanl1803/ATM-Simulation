package com.mitrais.studycase.atm.controllers;

import com.mitrais.studycase.atm.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountServiceImpl accountService;

    @RequestMapping(value = "/verifyAccount", method = RequestMethod.POST)
    public boolean verifyAccount() {

        return false;
    }

}
