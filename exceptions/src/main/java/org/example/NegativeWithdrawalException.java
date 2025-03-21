package org.example;

public class NegativeWithdrawalException extends ErrorBalanceException{
    public NegativeWithdrawalException(String message) {
        super(message);
    }
}
