package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.repos.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {
    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountServiceImpl accountService;

    @Test
    public void findByAccountNumberAndPin_Empty() {
        List<Account> accountList = new ArrayList<>();
        when(accountRepository.findByAccountNumberAndPin("empty", "empty")).thenReturn(accountList);
        assertEquals(accountService.findByAccountNumberAndPin("empty", "empty"), accountList);
    }

    @Test
    public void findByAccountNumberAndPin_NotEmpty() {
        List<Account> accountList = Arrays.asList(new Account("John", "123456", 100.0, "112233"));
        when(accountRepository.findByAccountNumberAndPin("112233", "123456")).thenReturn(accountList);
        assertEquals(accountService.findByAccountNumberAndPin("112233", "123456"), accountList);
    }

    @Test
    public void findByAccountNumber_Empty() {
        List<Account> accountList = new ArrayList<>();
        when(accountRepository.findByAccountNumber("empty")).thenReturn(accountList);
        assertEquals(accountService.findByAccountNumber("empty"), accountList);
    }

    @Test
    public void findByAccountNumber_NotEmpty() {
        List<Account> accountList = Arrays.asList(new Account("John", "123456", 100.0, "112233"));
        when(accountRepository.findByAccountNumber("112233")).thenReturn(accountList);
        assertEquals(accountService.findByAccountNumber("112233"), accountList);
    }

}