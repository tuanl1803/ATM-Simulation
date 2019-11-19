package com.mitrais.studycase.atm.repos;

import com.mitrais.studycase.atm.models.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query(value = "select * from transaction where account = ?1 order by date desc limit ?2", nativeQuery = true)
    List<Transaction> findNTransaction(String accountNumber, Integer n);

}
