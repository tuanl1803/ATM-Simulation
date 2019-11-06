package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Account;

import java.util.List;

public interface AccountService {

    boolean addAccount();

    boolean updateAccount();

    boolean deleteAccount();

    boolean verifyAccount(String accNumber, String pinNumber);

    List<Account> getAllAccounts();

    Account getAccountByAccNumber(String accNumber);
}
