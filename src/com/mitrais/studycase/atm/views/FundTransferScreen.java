package com.mitrais.studycase.atm.views;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.models.Transfer;
import com.mitrais.studycase.atm.services.AccountService;
import com.mitrais.studycase.atm.services.AccountServiceImpl;
import com.mitrais.studycase.atm.services.FundTransferService;
import com.mitrais.studycase.atm.services.FundTransferServiceImpl;
import com.mitrais.studycase.atm.utils.ValidationUtil;

import java.time.LocalDateTime;
import java.util.Scanner;

public class FundTransferScreen {

    public void showScreen1(Account fromAccount) {
        System.out.println();
        System.out.println("----------------");
        System.out.println("Fund Transfer Screen");
        System.out.println("----------------");
        System.out.println();
        System.out.print("Please enter destination account and \r\n" +
                "Press enter to continue or \r\n" +
                "Press cancel (Esc) to go back to Transaction: ");
        Scanner scan = new Scanner(System.in);
        String destinationNumber = scan.nextLine();
        if (ValidationUtil.validateAccNumber(destinationNumber)) {
            AccountService accountService = new AccountServiceImpl();
            Account desAccount = accountService.getAccountByAccNumber(destinationNumber);
            if (desAccount == null) {
                System.out.println("Invalid account");
                showScreen1(fromAccount);
            } else {
                showScreen2(fromAccount, desAccount);
            }
        }
    }

    public void showScreen2(Account fromAccount, Account desAccount) {
        System.out.println();
        System.out.print("Please enter transfer amount and \r\n" +
                "Press enter to continue or \r\n" +
                "Press cancel (Esc) to go back to Transaction: ");
        Scanner scan = new Scanner(System.in);
        int balance = fromAccount.getBalance();
        try {
            int amount = scan.nextInt();
            if (ValidationUtil.validateAmount(amount, balance)) {
                showScreen3(fromAccount, desAccount, amount);
            } else {
                showScreen2(fromAccount, desAccount);
            }
        } catch (Exception e) {
            System.out.println("Only Number Allowed");
            showScreen2(fromAccount, desAccount);
        }

    }

    public void showScreen3(Account fromAccount, Account desAccount, int amount) {

        System.out.println();
        System.out.print("Please enter reference number (Optional) and \r\n" +
                "Press enter to continue or \r\n" +
                "Press cancel (Esc) to go back to Transaction: ");
        Scanner scan = new Scanner(System.in);
        try {
            int referenceNum = scan.nextInt();
            Transfer transfer = new Transfer(fromAccount, desAccount, amount, referenceNum, LocalDateTime.now());
            showScreen4(transfer);
        } catch (Exception e) {
            System.out.println("Invalid Reference Number");
            showScreen3(fromAccount, desAccount, amount);
        }


    }

    public void showScreen4(Transfer transfer) {
        System.out.println();
        System.out.println("Transfer Confirmation");
        System.out.println("Destination Account: " + transfer.getDesAccount().getAccNumber());
        System.out.println("Transfer Amount: $" + transfer.getAmount());
        System.out.println("Reference Number: " + transfer.getReferenceNumber());

        System.out.println("1. Confirm Trx");
        System.out.println("2. Cancel Trx");

        Scanner scan = new Scanner(System.in);
        String opt = scan.nextLine();

        switch (opt) {
            case "1":
                FundTransferService fundTransferService = new FundTransferServiceImpl();
                fundTransferService.transferConfirmation(transfer);
                new FundTransferSummaryScreen().showScreen(transfer);
                break;
            case "2":
                new TransactionScreen().showScreen(transfer.getFromAccount());
                break;
            default:
                break;
        }


    }
}
