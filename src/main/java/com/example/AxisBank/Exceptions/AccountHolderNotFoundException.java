package com.example.AxisBank.Exceptions;

public class AccountHolderNotFoundException extends RuntimeException {
    public AccountHolderNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
