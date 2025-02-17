package main;

import main.entities.Department;
import main.entities.HourContract;
import main.entities.Worker;
import main.entities.enums.WorkerLevel;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        //Cria scanner
        Scanner sc = new Scanner(System.in);
        //Cria máscara de data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Cria variáveis de dados com os inputs do user
        System.out.print("Enter department's name:");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        //Cria objeto do tipo worker, atribuindo as variáveis acima no constructor
        Worker worker = new Worker(new Department(departmentName), baseSalary, WorkerLevel.valueOf(workerLevel), workerName);

        //Número de contrato desejado para o worker(também o numero de vezes que o loop abaixo irá rodar)
        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        //Loop para a criação dos contratos, com base no número inputado acima
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Durations (hours):");
            int hours = sc.nextInt();

            //Cria objeto do tipo HourContract, atribuindo as variáveis acima no constructor
            HourContract contract = new HourContract(contractDate,valuePerHour,hours);
            //Método para adicionar o contrato a lista de contrato do Worker
            worker.addContract(contract);
        }

        System.out.println();

        //Coleta data para calculo em formato de string
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();

        //Pega os dois primeiros caracteres da string(mês), e transforma em INT
        int month = Integer.parseInt(monthAndYear.substring(0, 2));

        //Pega do terceiro caractere em diante(ano), e transforma em INT
        int year =  Integer.parseInt(monthAndYear.substring(3));

        //IMPRIME DADOS DO WORKER
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
