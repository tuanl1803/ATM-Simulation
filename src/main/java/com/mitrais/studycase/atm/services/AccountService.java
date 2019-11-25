package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Account;

import java.util.List;

public interface AccountService {

    List<Account> findByAccountNumberAndPin(String accountNumber, String pin);

    List<Account> findByAccountNumber(String accountNumber);

    Account saveAccount(Account account);
}
