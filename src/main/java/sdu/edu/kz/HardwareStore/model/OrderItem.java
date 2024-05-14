package sdu.edu.kz.HardwareStore.model;

import lombok.Setter;

public class OrderItem {
    private Long id;
    private Integer quantity;
    private Double price;  // Price per unit
    @Setter
    private Order order;

    public OrderItem(Long productId, Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }
    public Double getSubTotal() {
        return quantity * price;
    }
}