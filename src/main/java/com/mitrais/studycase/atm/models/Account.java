package com.mitrais.studycase.atm.models;

import javax.persistence.*;

@Entity
@Table(name = "user")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "accNumber")
    private String accNumber;
    @Column(name = "pinNumber")
    private String pinNumber;
    @Column(name = "balance")
    private int balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(String name, String accNumber, String pinNumber, int balance) {
        this.name = name;
        this.accNumber = accNumber;
        this.pinNumber = pinNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accNumber='" + accNumber + '\'' +
                ", pinNumber='" + pinNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
