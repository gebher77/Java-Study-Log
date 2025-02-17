package main;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING (SUBCLASSE => SUPERCLASSE)
        // O upcasting não gera erro porque um objeto de uma subclasse (BusinessAccount) também é um tipo da superclasse (Account)
        // A herança representa uma relação "é um", então uma BusinessAccount é também uma Account. (tipoSubClasse == tipoSuperClasse)
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);


        // DOWNCASTING (SUPERCLASSE => SUBCLASSE)
        // Para realizar o downcasting, basta especificar a subclasse entre parênteses (tipoSubclasse). Caso o objeto seja compatível, o cast será bem-sucedido.
        BusinessAccount acc4 = (BusinessAccount)acc2;
        acc4.loan(100.00);

        // Antes de realizar o downcasting, é importante verificar o tipo do objeto com instanceof, como nos exemplos abaixo.

        // Verifica se acc3 é uma instância do tipo BusinessAccount (instanceof verifica se o objeto é uma instância de)
        // Como acc3 é uma instância do tipo SavingsAccount, a condição retornará falso.
        if (acc3 instanceof BusinessAccount){
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        // Verifica se acc3 é uma instância de SavingsAccount.
        // Como acc3 é de fato uma instância do tipo SavingsAccount, a condição será verdadeira.
        if (acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }
    }
}
