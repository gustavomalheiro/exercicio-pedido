package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdfBirthDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfOrderMoment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		double totalPrice = 0;
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
	    String clientName = sc.nextLine();
	    System.out.print("E-mail: ");
	    String clientEmail = sc.nextLine();
	    System.out.print("Birth date (DD/MM/YYYY): ");
	    Date clientBirthDate = sdfBirthDate.parse(sc.next());
	    
	    Client client = new Client(clientName, clientEmail, clientBirthDate);
	    
	    System.out.println();
	    
	    System.out.println("Enter order data: ");
	    System.out.print("Status: ");
	    sc.nextLine();
	    String orderStatus = sc.next();
	    
	    sc.nextLine();
	    
	    Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), client);
	    
	    System.out.print("How many items to this order? ");
	    int n = sc.nextInt();
	    
	    System.out.println();
	    
	    for (int i = 1; i <= n; i++) {
	    	System.out.println("Enter #" + i + " item data: ");
	    	System.out.printf("Product name: ");
	    	String productName = sc.next();
	    	System.out.print("Product price: ");
	    	double productPrice = sc.nextDouble();
	    	System.out.print("Quantity: ");
	    	int productQuantity = sc.nextInt();
	    	
	    	OrderItem item = new OrderItem(new Product(productName, productPrice), productQuantity);
	    	order.addItem(item);
	    	System.out.println();
	    }
	    
	    
	    System.out.println("ORDER SUMMARY: ");
	    System.out.println("Order moment: " + sdfOrderMoment.format(order.getMoment()));
	    System.out.println("Order status: " + order.getStatus());
	    System.out.println("Client: " + order.getClient().getName() + " (" + sdfBirthDate.format(order.getClient().getBirthDate()) + ") - " + order.getClient().getEmail());
	    
	    System.out.println("Order items:");
	    
	    System.out.println();
	    
	    for (OrderItem i: order.getItems()) {

	    	System.out.println(i.getProduct().getName() + ", $" + i.getProduct().getPrice() + ", Quantity: " + i.getQuantity() + ", Subtotal: $" + i.subTotal());
	    	
	    	totalPrice += i.subTotal();
	    }
	    
	    System.out.println("Total price: $" + totalPrice);
	    
		sc.close();
	}
}
