package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Account;

public class WithdrawServiceImpl implements WithdrawService {
    @Override
    public void withdrawAmount(Account account, int amount) {
        account.setBalance(account.getBalance() - amount);
    }
}
