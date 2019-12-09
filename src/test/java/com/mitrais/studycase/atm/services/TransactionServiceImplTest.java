package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.constants.TransactionType;
import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.models.Transaction;
import com.mitrais.studycase.atm.repos.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTest {
    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    TransactionServiceImpl transactionService;

    @Test
    public void findNTransaction_Empty() {
        List<Transaction> transactionList = new ArrayList<>();
        when(transactionRepository.findNTransaction("empty", 0)).thenReturn(transactionList);
        assertEquals(transactionService.findNTransaction("empty", 0), transactionList);
    }

    @Test
    public void findNTransaction_NotEmpty() {
        Account fromAccount = new Account("John", "123456", 100.0, "112233");
        Account desAccount = new Account("John", "123456", 100.0, "112244");
        Transaction transaction = new Transaction(TransactionType.TRANSFER, fromAccount, 10.0, new Date(),desAccount, "2");
        List<Transaction> transactionList = Arrays.asList(transaction);
        when(transactionRepository.findNTransaction("112233", 1)).thenReturn(transactionList);
        assertEquals(transactionService.findNTransaction("112233", 1), transactionList);
    }
}