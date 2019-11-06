package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {
    @Override
    public boolean addAccount() {
        return false;
    }

    @Override
    public boolean updateAccount() {
        return false;
    }

    @Override
    public boolean deleteAccount() {
        return false;
    }

    @Override
    public boolean verifyAccount(String accNumber, String pinNumber) {
        List<Account> accountList = getAllAccounts();
        for (Account account : accountList) {
            if (accNumber.equals(account.getAccNumber()) && pinNumber.equals(account.getPinNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("John Doe", "112233", "012108", 100));
        accountList.add(new Account("Jane Doe", "112244", "932012", 30));
        return accountList;
    }

    @Override
    public Account getAccountByAccNumber(String accNumber) {
        List<Account> accountList = getAllAccounts();
        List<Account> accountListFilter = accountList.stream().
                filter(account -> accNumber.equals(account.getAccNumber()))
                .collect(Collectors.toList());
        return accountListFilter.get(0);
    }
}
