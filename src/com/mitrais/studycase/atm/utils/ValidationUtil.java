package com.mitrais.studycase.atm.utils;

public class ValidationUtil {
    private ValidationUtil() {
    }

    public static boolean validateAccNumber(String accNumber) {
        String regex = "[0-9]+";
        int accLength = accNumber.length();
        boolean validate = true;
        if (accLength != 6) {
            System.out.println("Account Number should have 6 digits length");
            validate = false;
        }
        if (!accNumber.matches(regex)) {
            System.out.println("Account Number should only contains numbers");
            validate = false;
        }
        return validate;
    }

    public static boolean validatePinNumber(String pinNumber) {
        String regex = "[0-9]+";
        int pinLength = pinNumber.length();
        boolean validate = true;
        if (pinLength != 6) {
            System.out.println("PIN should have 6 digits length");
            validate = false;
        }
        if (!(pinNumber.matches(regex))) {
            System.out.println("PIN should only contains numbers");
            validate = false;
        }
        return validate;
    }

    public static boolean validateAmount(int amount, int balance) {
        boolean validate = true;
        if (amount % 10 != 0) {
            System.out.println("Invalid amount");
            validate = false;
        } else if (amount > 1000) {
            System.out.println("Maximum amount to withdraw is $1000");
            validate = false;
        } else if (balance - amount < 0) {
            System.out.println("Insufficient balance $" + amount);
            validate = false;
        } else if (amount < 1) {
            System.out.println("Minimum amount to transfer is $1");
            validate = false;
        }
        return validate;
    }

}
