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
public class WithdrawControllerTest {

    @InjectMocks
    WithdrawController withdrawController;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(withdrawController).build();
    }

    @Test
    public void withdraw_redirect() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        Map<String, Object> attributesMap = new HashMap<>();
        attributesMap.put("account", new Account("John", "123456", 100.0, "112233"));
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/withdraw").session(mockHttpSession).sessionAttrs(attributesMap);
        mvc.perform(mockHttpServletRequestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.forwardedUrl("withdraw/index"));
    }

    @Test
    public void withdraw_redirectWelcome() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/withdraw").session(mockHttpSession);
        mvc.perform(mockHttpServletRequestBuilder).andExpect(MockMvcResultMatchers.status().is3xxRedirection()).andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }
}