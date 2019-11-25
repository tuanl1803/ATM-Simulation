package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findByAccountNumberAndPin(String accountNumber, String pin) {
        return accountRepository.findByAccountNumberAndPin(accountNumber, pin);
    }

    @Override
    public List<Account> findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

}
