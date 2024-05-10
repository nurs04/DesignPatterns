package sdu.edu.kz.HardwareStore.model;

public class OrderItem {
    private Long id;
    private Long productId;
    private Integer quantity;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
    private Order order;
}
