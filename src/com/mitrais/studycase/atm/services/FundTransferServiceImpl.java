package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.models.Transfer;

public class FundTransferServiceImpl implements FundTransferService {
    @Override
    public void transferConfirmation(Transfer transfer) {
        Account fromAccount = transfer.getFromAccount();
        Account desAccount = transfer.getDesAccount();
        int fromBalance = fromAccount.getBalance();
        fromAccount.setBalance(fromBalance - transfer.getAmount());
        int desBalance = desAccount.getBalance();
        desAccount.setBalance(desBalance + transfer.getAmount());
    }
}
