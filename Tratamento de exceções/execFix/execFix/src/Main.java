import br.com.execFix.model.entities.Account;
import br.com.execFix.model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account data");

        System.out.print("Number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Holder: ");
        String holder = scanner.nextLine();

        System.out.print("Initial balance: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Withdraw limit: ");
        double withdrawLimit = scanner.nextDouble();

        System.out.println("Enter amount for withdraw: ");
        double amount = scanner.nextDouble();

        Account account = new Account(number,holder,initialBalance, withdrawLimit);

        try {
            account.withdraw(amount);
            System.out.printf("New balance: %.2f%n", account.getBalance());
        }catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }


        scanner.close();
    }
}
