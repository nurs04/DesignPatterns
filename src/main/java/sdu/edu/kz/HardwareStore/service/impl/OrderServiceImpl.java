package sdu.edu.kz.HardwareStore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdu.edu.kz.HardwareStore.model.Order;
import sdu.edu.kz.HardwareStore.repository.OrderRepository;
import sdu.edu.kz.HardwareStore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void placeOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        }
    }
    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}