package com.mitrais.studycase.atm.views;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.services.WithdrawService;
import com.mitrais.studycase.atm.services.WithdrawServiceImpl;
import com.mitrais.studycase.atm.utils.ValidationUtil;

import java.util.Scanner;

public class WithdrawScreen {
    public void showScreen(Account account) {
        System.out.println();
        System.out.println("----------------");
        System.out.println("Withdraw Screen");
        System.out.println("----------------");
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");

        Scanner scan = new Scanner(System.in);
        String opt = scan.nextLine();
        WithdrawService withdrawServices = new WithdrawServiceImpl();
        SummaryScreen summaryScreen = new SummaryScreen();
        int balance = account.getBalance();
        int amount = 0;
        switch (opt) {
            case "1":
                amount = 10;
                if (ValidationUtil.validateAmount(amount, balance)) {
                    withdrawServices.withdrawAmount(account, amount);
                    summaryScreen.showScreen(account, amount);
                } else {
                    showScreen(account);
                }
                break;
            case "2":
                amount = 50;
                if (ValidationUtil.validateAmount(amount, balance)) {
                    withdrawServices.withdrawAmount(account, amount);
                    summaryScreen.showScreen(account, amount);
                } else {
                    showScreen(account);
                }
                break;
            case "3":
                amount = 100;
                if (ValidationUtil.validateAmount(amount, balance)) {
                    withdrawServices.withdrawAmount(account, amount);
                    summaryScreen.showScreen(account,amount);
                } else {
                    showScreen(account);
                }
                break;
            case "4":
                new OtherWithdrawScreen().showScreen(account);
                break;
            case "5":
                new TransactionScreen().showScreen(account);
                break;
            default:
                break;
        }

    }

}
