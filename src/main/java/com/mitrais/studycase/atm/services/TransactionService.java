package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findNTransaction(String accountNumber, Integer n);

    Transaction saveTransaction(Transaction transaction);
}
