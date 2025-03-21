package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank newBankAccount = null;
        while (true) {
            System.out.println("\nВыберите действие: \n1. Открыть новый счет \n2. Посмотреть баланс\n3. Снять деньги\n4. Пополнить счет\n5. Выйти");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Введите свое имя:");
                    String name = scanner.next();
                    int balance;
                    while (true) {
                        try {
                            System.out.println("Введите начальную сумму счета:");
                            balance = scanner.nextInt();

                            Bank.ValidateInputBalanceInConstructor(balance);

                            break;
                        } catch (NegativeInputBalanceException e) {
                            System.out.println("Недопустимое значение баланса");
                        }
                    }
                    newBankAccount = new Bank(name, balance);
                    Bank.AddNewBankAccount(newBankAccount);
                    break;
                case 2:
                    if(newBankAccount != null){
                        System.out.printf("Баланс: %d", newBankAccount.getBalance());
                    } else {
                        System.out.println("Такого счета не существует");
                    }
                    break;
                case 3:
                    while (true) {
                        try {
                            System.out.println("Введите сумму, которую хотите снять:");
                            int amount = scanner.nextInt();
                            newBankAccount.windrawMoney(amount);
                            break;
                        }  catch (ErrorBalanceException e) {
                            System.out.println("Введено некорректное значение");
                        }
                    }
                    break;
                case 4:

                    while (true) {
                        try {
                            System.out.println("Введите сумму, которую хотите положить на счет:");
                            int addAmount = scanner.nextInt();
                            newBankAccount.addMoney(addAmount);
                            break;
                        }  catch (ErrorBalanceException e) {
                            System.out.println("Введено некорректное значение");
                        }
                    }
                    break;
                case 5:
                    break;
            }
        }
    }
}