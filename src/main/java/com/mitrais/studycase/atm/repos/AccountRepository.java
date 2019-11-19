package com.mitrais.studycase.atm.repos;

import com.mitrais.studycase.atm.models.Account;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, String> {

    List<Account> findByAccountNumberAndPin(String accountNumber, String pin);

    List<Account> findByAccountNumber(String accountNumber);

}