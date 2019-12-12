package com.mitrais.studycase.atm.controllers;

import com.mitrais.studycase.atm.models.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {

    private MockMvc mvc;

    @InjectMocks
    TransactionController transactionController;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(transactionController).build();
    }

    @Test
    public void transaction_redirectTransaction() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        Map<String, Object> attributesMap = new HashMap<>();
        Account account = new Account("John", "123456", 100.0, "112233");
        attributesMap.put("account", account);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/transaction").session(mockHttpSession).sessionAttrs(attributesMap);
        mvc.perform(mockHttpServletRequestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.forwardedUrl("transaction/index")).andExpect(MockMvcResultMatchers.model().attribute("accountNumber",account.getAccountNumber()));
    }

    @Test
    public void transaction_redirectWelcome() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/transaction").session(mockHttpSession);
        mvc.perform(mockHttpServletRequestBuilder).andExpect(MockMvcResultMatchers.status().is3xxRedirection()).andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }

}