package sdu.edu.kz.HardwareStore.model;

import java.util.Set;

public class Order {
    private Long id;
    private Long userId;
    private Double total;

//    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;
}
