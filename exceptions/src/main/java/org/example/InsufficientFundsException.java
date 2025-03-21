package org.example;

public class InsufficientFundsException extends ErrorBalanceException{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
