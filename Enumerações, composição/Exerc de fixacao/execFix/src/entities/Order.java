package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    //Mascaras para o uso no toString
    private static SimpleDateFormat sdfOrder = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static  SimpleDateFormat sdfClient = new SimpleDateFormat("dd/MM/yyyy");

    private Date moment;
    private OrderStatus status;

    //Associações
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public java.util.Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    //Adiciona item na lista
    public void addItem(OrderItem item){
        items.add(item);
    }
    //Remove item da lista
    public void removeItem(OrderItem item){
        items.remove(item);
    }

    //Calcula o valor TOTAL do pedido
    public double total(){
        return items.stream()
              .mapToDouble(OrderItem::subTotal)
                .sum();
    }


    //toString usando o StringBuilder
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Order moment: ");
    sb.append(sdfOrder.format(moment) + "\n");

    sb.append("Order status: ");
    sb.append(status + "\n");

    sb.append("Client: ");
    sb.append(client.getName());
    sb.append(" (" + sdfClient.format(client.getBirthDate()) + ")");
    sb.append(" - " + client.getEmail());

    sb.append("\nOrder items:" + "\n");

    items.forEach(i -> {

        sb.append(i.getProduct().getName() + ", ");
        sb.append("$" + String.format("%.2f", i.getProduct().getPrice()) + ", ");
        sb.append("Quantity: ");
        sb.append(i.getQuantity() + ", ");
        sb.append("Subtotal: $");
        sb.append(String.format("%.2f", i.subTotal()));
        sb.append("\n");
    });

    sb.append("\n");
    sb.append("Total price: ");
    sb.append(String.format("%.2f", total()));

    return sb.toString();
    }
}
