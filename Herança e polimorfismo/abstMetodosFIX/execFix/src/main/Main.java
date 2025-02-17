package main;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax player #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char ch = scanner.next().charAt(0);

            if (ch == 'i') {
                System.out.print("Name: ");
                String name = scanner.next();

                System.out.print("Anual income: ");
                double anualIncome = scanner.nextDouble();

                System.out.println("Health expenditures: ");
                double healthExpenditures = scanner.nextDouble();

                list.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Name: ");
                String name = scanner.next();

                System.out.print("Anual income: ");
                double anualIncome = scanner.nextDouble();

                System.out.println("Number of employees: ");
                int numberOfEmployees = scanner.nextInt();

                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        double sum = 0.0;

        for (TaxPayer e : list) {

            System.out.println(e.getName() + ": $ " + String.format("%.2f", e.tax()));
            sum += e.tax();

        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

        scanner.close();

    }

}
