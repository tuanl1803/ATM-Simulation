package com.mitrais.studycase.atm.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class WelcomeControllerTest {
    @Mock
    HttpServletRequest httpServletRequest;

    @InjectMocks
    WelcomeController welcomeController;
    @Test
    public void inputAccountNumber_redirectTransactionPage() {
    }
}