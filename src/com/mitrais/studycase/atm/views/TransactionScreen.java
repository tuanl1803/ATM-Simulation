package com.mitrais.studycase.atm.views;


import com.mitrais.studycase.atm.models.Account;

import java.util.Scanner;

public class TransactionScreen {
    public void showScreen(Account account) {
        System.out.println();
        System.out.println("----------------");
        System.out.println("Transaction Screen");
        System.out.println("----------------");

        System.out.println("1. Withdraw ");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit ");

        Scanner scan = new Scanner(System.in);
        String opt = scan.nextLine();

        switch (opt) {
            case "1":
                new WithdrawScreen().showScreen(account);
                break;
            case "2":
                new FundTransferScreen().showScreen1(account);
                break;
            case "3":
                new WelcomeScreen().showScreen();
                break;
            default:
                break;
        }
    }
}
