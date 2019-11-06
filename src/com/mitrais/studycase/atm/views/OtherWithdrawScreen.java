package com.mitrais.studycase.atm.views;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.services.WithdrawService;
import com.mitrais.studycase.atm.services.WithdrawServiceImpl;
import com.mitrais.studycase.atm.utils.ValidationUtil;

import java.util.Scanner;

public class OtherWithdrawScreen {
    public void showScreen(Account account) {

        System.out.println();
        System.out.println("--------------------");
        System.out.println("Other Withdraw Screen");
        System.out.println("--------------------");
        System.out.print("Enter amount to withdraw: ");
        Scanner scan = new Scanner(System.in);
        try {
            int amount = scan.nextInt();
            int balance = account.getBalance();
            if (ValidationUtil.validateAmount(amount, balance)) {
                WithdrawService withdrawService = new WithdrawServiceImpl();
                withdrawService.withdrawAmount(account, amount);
                new SummaryScreen().showScreen(account, amount);
            } else {
                new WithdrawScreen().showScreen(account);
            }
        } catch (Exception e) {
            System.out.println("Only Number Allowed");
            showScreen(account);

        }
    }
}
