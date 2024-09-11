
package javaproject;

import java.time.LocalDate;


class Order {    
    private int orderId;
    private String customerName;
    private LocalDate orderDate;
    private double orderAmount;
    private int orderStatus;  // 1 - Pending, 2 - Shipped, 3 - Delivered, 4 - Cancelled

    public Order(int orderId, String customerName, LocalDate orderDate, double orderAmount, int orderStatus) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
    }

  
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
               ", Customer Name: " + customerName +
               ", Order Date: " + orderDate +
               ", Order Amount: $" + String.format("%.2f", orderAmount) +
               ", Order Status: " + getOrderStatusString();
    }

    private String getOrderStatusString() {
        switch (orderStatus) {
            case 1: return "Pending";
            case 2: return "Shipped";
            case 3: return "Delivered";
            case 4: return "Cancelled";
            default: return "Unknown";
        }
    }
}
