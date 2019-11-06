package com.mitrais.studycase.atm.views;

import com.mitrais.studycase.atm.models.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SummaryScreen {
    public void showScreen(Account account, int amount) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println();
        System.out.println("----------------");
        System.out.println("Summary Screen");
        System.out.println("----------------");
        System.out.println("Date : " + dtf.format(now));
        System.out.println("Withdraw: $" + amount);
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("1. Transfer");
        System.out.println("2. Exit");
        Scanner scan = new Scanner(System.in);
        int opt = scan.nextInt();
        switch (opt) {
            case 1:
                new TransactionScreen().showScreen(account);
                break;
            case 2:
                new WelcomeScreen().showScreen();
                break;
            default:
                break;
        }
    }
}
