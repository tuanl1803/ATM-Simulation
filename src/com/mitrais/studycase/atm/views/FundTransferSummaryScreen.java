package com.mitrais.studycase.atm.views;

import com.mitrais.studycase.atm.models.Transfer;

import java.util.Scanner;

public class FundTransferSummaryScreen {
    public void showScreen(Transfer transfer) {
        System.out.println();
        System.out.println("Fund Transfer Summary Screen");
        System.out.println("----------------------");

        System.out.println("Destination Account: " + transfer.getDesAccount().getAccNumber());
        System.out.println("Transfer Amount: $" + transfer.getAmount());
        System.out.println("Reference Number: " + transfer.getReferenceNumber());
        System.out.println("Balance: $" + transfer.getFromAccount().getBalance());

        System.out.println("1. Transaction");
        System.out.println("2. Exit");
        Scanner scan = new Scanner(System.in);
        String opt = scan.nextLine();

        switch (opt) {
            case "1":
                new TransactionScreen().showScreen(transfer.getFromAccount());
                break;
            case "2":
                new WelcomeScreen().showScreen();
                break;
            default:
                break;
        }
    }
}
