package main;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        //Usando o método direto da classe account(sem estar sobrescrito na SavingsAccount)
        //DESCONTA A TAXA DE 5
        Account acc1 = new Account(1001, "Alex", 1000.0);
        acc1.withdraw(200.00);
        System.out.println(acc1.getBalance());

        //upcasting + uso do método sobrescrito
        //Não desconta a taxa de 5
        Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
        acc2.withdraw(200.00);
        System.out.println(acc2.getBalance());

        //upcasting + uso do método sobrescrito
        //Utiliza o método de saque padrao da Account e desconta mais 2.0 (sobrescrito na BusinessAccount)
        Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
        acc3.withdraw(200.0);
        System.out.println(acc3.getBalance());
    }
}
