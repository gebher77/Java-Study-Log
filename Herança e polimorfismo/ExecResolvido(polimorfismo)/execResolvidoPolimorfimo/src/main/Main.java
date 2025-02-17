package main;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        //Abre scanner
        Scanner sc = new Scanner(System.in);

        //Cria lista do tipo Employee
        List<Employee> list = new ArrayList<>(  );

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        //Loop para criar os objetos do tipo Employee e adicioná-los
        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Hours: ");
            int hours = sc.nextInt();
            System.out.println("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            //Confere se o funcionário é terceirizado ou não
            if (ch == 'y'){
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            }else{
                list.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("PAYMENTS:");

        //Itera a lista e imprime os dados
        list.forEach(e -> {
            System.out.println(e.getName() + " - $ " + String.format("%.2f", e.payment()));
        });

    }
}
