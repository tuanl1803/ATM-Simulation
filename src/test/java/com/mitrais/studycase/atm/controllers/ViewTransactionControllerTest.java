package com.mitrais.studycase.atm.controllers;

import com.mitrais.studycase.atm.constants.TransactionType;
import com.mitrais.studycase.atm.models.Account;
import com.mitrais.studycase.atm.models.Transaction;
import com.mitrais.studycase.atm.services.TransactionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ViewTransactionControllerTest {
    private MockMvc mvc;

    @InjectMocks
    ViewTransactionController viewTransactionController;

    @Mock
    TransactionServiceImpl transactionService;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(viewTransactionController).build();
    }
    @Test
    public void viewTransaction_redirectTransaction() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        Map<String, Object> attributesMap = new HashMap<>();
        Account account = new Account("John", "123456", 100.0, "112233");
        Account desAccount = new Account("John", "123456", 100.0, "112244");
        attributesMap.put("account", account);
        Transaction transaction = new Transaction(TransactionType.TRANSFER, account, 10.0, new Date(),desAccount, "2");
        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);
        when(transactionService.findNTransaction(any(), any())).thenReturn(listTransaction);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/view-transaction").session(mockHttpSession).sessionAttrs(attributesMap);
        mvc.perform(mockHttpServletRequestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.forwardedUrl("transaction/transaction"));
    }

}