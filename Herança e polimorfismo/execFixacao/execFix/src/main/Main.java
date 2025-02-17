package main;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        //Looping para adicionar os itens a lista
        for (int i = 1; i <= n; i++) {

            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)?");
            char type = sc.next().charAt(0);

            //Condições para checar o tipo do produto
            if (type == 'c') {

                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.println("Price: ");
                double price = sc.nextDouble();

                list.add(new Product(name, price));
            } else if (type == 'u') {

                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.next());

                list.add(new UsedProduct(name, price, date));
            } else if (type == 'i') {

                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                System.out.print("Customs fee: ");
                double fee = sc.nextDouble();

                list.add(new ImportedProduct(name, price, fee));

            } else {
                System.out.print("ERROR, TRY AGAIN PLEASE");
            }

        }
        System.out.println();
        System.out.println("PRICE TAGS: ");
        //Iteração e impressão dos itens da lista
        list.forEach(e -> {
            System.out.println(e.priceTag());
        });
    }
}
