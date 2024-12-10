package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderService
{
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        // Additional logic such as saving to database can be added here
    }

    public List<Order> getOrders() {
        return orders;
    }
}