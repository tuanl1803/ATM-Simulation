package com.mitrais.studycase.atm.views;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.services.AccountService;
import com.mitrais.studycase.atm.services.AccountServiceImpl;
import com.mitrais.studycase.atm.utils.ValidationUtil;

import java.util.Scanner;

public class WelcomeScreen {

    public void showScreen() {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("----------------");
        System.out.println("Welcome Screen");
        System.out.println("----------------");
        System.out.print("Enter Account Number: ");
        String accNumber = scan.nextLine();
        System.out.print("Enter PIN: ");
        String pinNumber = scan.nextLine();
        if (ValidationUtil.validateAccNumber(accNumber) && ValidationUtil.validatePinNumber(pinNumber)) {
            AccountService accountService = new AccountServiceImpl();
            boolean verify = accountService.verifyAccount(accNumber, pinNumber);
            if (verify) {
                Account account = accountService.getAccountByAccNumber(accNumber);
                new TransactionScreen().showScreen(account);
            } else {
                System.out.println("Invalid Account Number or PIN");
            }
        }
    }



}
