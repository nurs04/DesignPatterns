package sdu.edu.kz.HardwareStore.model;

import java.util.HashSet;
import java.util.Set;

public class Order {
    private Long id;
    private Double total;
    private Set<OrderItem> orderItems = new HashSet<>();

    public Order(String userId) {
        this.total = 0.0;
    }

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
        item.setOrder(this);
        total += item.getSubTotal();
    }
}