package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.repos.AccountRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountServiceImplTest {

    @Test
    void findByAccountNumberAndPin_Empty() {
        List<Account> accountList = new ArrayList<>();
        AccountRepository accountRepositoryMock = mock(AccountRepository.class);

        when(accountRepositoryMock.findByAccountNumberAndPin("empty","empty")).thenReturn(accountList);
        AccountServiceImpl  accountService = new AccountServiceImpl();
        assertEquals(accountService.findByAccountNumberAndPin("empty","empty"), accountList);
    }

    @Test
    void findByAccountNumberAndPin_NotEmpty() {
        List<Account> accountList =  Arrays.asList(new Account("John","123456", 100.0,"112233" ));
        AccountRepository accountRepositoryMock = mock(AccountRepository.class);

        when(accountRepositoryMock.findByAccountNumberAndPin("112233","123456")).thenReturn(accountList);
        AccountServiceImpl  accountService = new AccountServiceImpl();
        assertEquals(accountService.findByAccountNumberAndPin("112233","123456"), accountList);
    }
    @Test
    void findByAccountNumber() {
    }

    @Test
    void saveAccount() {
    }
}