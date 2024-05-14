package sdu.edu.kz.HardwareStore.service;


import sdu.edu.kz.HardwareStore.model.Order;

public interface OrderService {
    void placeOrder(Order order);
    void updateOrder(Order order);
    void cancelOrder(Long orderId);
    void saveOrder(Order order);

}

