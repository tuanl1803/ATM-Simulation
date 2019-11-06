package com.mitrais.studycase.atm.services;

import com.mitrais.studycase.atm.models.Account;

public interface WithdrawService {
   void withdrawAmount(Account account, int amount);
}
