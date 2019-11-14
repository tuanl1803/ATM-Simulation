package com.mitrais.studycase.atm.models;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "fromAccount")
    private String fromAccount;
    @Column(name = "desAccount")
    private String desAccount;
    @Column(name = "amount")
    private int amount;
    @Column(name = "referenceNumber")
    private int referenceNumber;
    @Column(name = "time")
    private LocalDateTime time;

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getDesAccount() {
        return desAccount;
    }

    public void setDesAccount(String desAccount) {
        this.desAccount = desAccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Transfer(String fromAccount, String desAccount, int amount, int referenceNumber, LocalDateTime time) {
        this.fromAccount = fromAccount;
        this.desAccount = desAccount;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
        this.time = time;
    }
}
