package main;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {


        Locale.setDefault(Locale.US);

        //Iniciar scanner
        Scanner sc = new Scanner(System.in);


        //Cria máscara para datas
        SimpleDateFormat sdfClient = new SimpleDateFormat("dd/MM/yyyy");


        //Atribui os valores dos inputs as respectivas variáveis
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date bDate = sdfClient.parse(sc.next());


        //Instancia um objeto do tipo Client usando as variáveis acima como parâmetros no constructor
        Client client1 = new Client(name, email, bDate);

        System.out.println();
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = sc.next();

        //Instancia um objeto do tipo order, usando o objeto do tipo Client + parâmetros no constructor
        Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), client1);

        //n = numero de vezes que o loop irá rodar
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        //Loop
        //Loop responsável pela criação do produto e ordemItem.
        //Loop também é responsável por adicionar o ordemItem dentro da lista presente no order(do tipo ordemItem)
        for (int i = 1; i <= n; i++) {

            System.out.println("Enter #" +i + " item data:");

            System.out.print("Product name: ");
            String nameP = sc.next();

            System.out.print("Product price: ");
            double priceP = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantityP = sc.nextInt();

            Product product = new Product(nameP, priceP);
            OrderItem itemOrder = new OrderItem(quantityP, priceP, product);
            order.addItem(itemOrder);
        }

        System.out.println();

        System.out.println("ORDER SUMMARY:");

        System.out.println(order);

        //fecha scanner
        sc.close();
    }

}
