package javaproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerRecords {
    private List<Order> orders;

   
    public CustomerRecords() {
        orders = new ArrayList<>();
    }

   
    public void addOrder(Order order) {
        orders.add(order);
    }

    
    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders to display.");
            return;
        }
        orders.forEach((order) -> {
            System.out.println(order);
        });
    }

   
    public void inputOrderDetails() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter number of orders: ");
            int numOrders = scanner.nextInt();
            scanner.nextLine();  

            for (int i = 0; i < numOrders; i++) {
                System.out.println("Order " + (i + 1) + ":");

                System.out.print("Enter Order ID: ");
                int orderId = scanner.nextInt();
                scanner.nextLine();  

                System.out.print("Enter Customer Name: ");
                String customerName = scanner.nextLine();

                System.out.print("Enter Order Date (YYYY-MM-DD): ");
                LocalDate orderDate;
                while (true) {
                    try {
                        orderDate = LocalDate.parse(scanner.nextLine());
                        break;  
                    } catch (Exception e) {
                        System.out.print("Invalid date format. Please enter again (YYYY-MM-DD): ");
                    }
                }

                System.out.print("Enter Order Amount: ");
                double orderAmount = scanner.nextDouble();
                scanner.nextLine();  

                System.out.println("Order Status Codes:");
                System.out.println("1 - Pending");
                System.out.println("2 - Shipped");
                System.out.println("3 - Delivered");
                System.out.println("4 - Cancelled");

                int orderStatus;
                while (true) {
                    System.out.print("Enter Order Status Code: ");
                    orderStatus = scanner.nextInt();
                    scanner.nextLine();  

                    if (orderStatus >= 1 && orderStatus <= 4) {
                        break;  
                    } else {
                        System.out.println("Invalid status code. Please enter a valid code (1-4).");
                    }
                }

                
                Order order = new Order(orderId, customerName, orderDate, orderAmount, orderStatus);
                addOrder(order);
            }
        } finally {
            scanner.close();  
        }
    }

   
    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

      
        records.inputOrderDetails();

        System.out.println("\nOrder Records:");
        records.displayOrders();
    }
}

