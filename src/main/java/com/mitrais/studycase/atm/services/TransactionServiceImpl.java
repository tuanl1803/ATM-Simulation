package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Transaction;
import com.mitrais.studycase.atm.repos.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findNTransaction(String accountNumber, Integer n) {
        return transactionRepository.findNTransaction(accountNumber, n);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
