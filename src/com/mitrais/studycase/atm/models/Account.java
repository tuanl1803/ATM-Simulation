package com.mitrais.studycase.atm.models;

public class Account {
    private String name;
    private String accNumber;
    private String pinNumber;
    private int balance;

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
