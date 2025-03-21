package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private int balance;
    private String name;
    private static List<Bank> bankList = new ArrayList<>();
    public Bank(String name, int balance){
        this.name = name;
        this.balance = balance;
        System.out.printf("Счет для %s с суммой %d рублей успешно открыт", name, balance);
    }
    public static void AddNewBankAccount(Bank bankAccount){
        bankList.add(bankAccount);
    }
    public static void ValidateInputBalanceInConstructor(int balance) throws NegativeInputBalanceException {
        if(balance<0){
            throw new NegativeInputBalanceException("ErrorBalanceException: Negative input balance exception");
        }
    }
    public void ValidateInputAmount(int amount) throws ErrorBalanceException{
        if(amount>balance){
            throw new InsufficientFundsException("ErrorBalanceException: Insufficient funds exception");
        } else if(amount<0){
            throw new NegativeWithdrawalException("ErrorBalanceException: Negative withdrawal exception");
        }
    }
    public int getBalance(){
        return balance;
    }
    public void windrawMoney(int amount) throws ErrorBalanceException {
        ValidateInputAmount(amount);
        balance -= amount;
        System.out.printf("Вы сняли со счета %d рублей, осталось %d рублей", amount, balance);
    }
    public void addMoney(int amount) throws ErrorBalanceException{
        try {
            ValidateInputAmount(amount);
        } catch (NegativeWithdrawalException e) {
            System.out.println("Нельзя пополнить счет на отрицательную сумму");
        }
        balance += amount;
        System.out.printf("Вы пополнили счет на %d рублей, баланс: %d рублей", amount, balance);
    }
}
