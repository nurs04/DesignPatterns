package sdu.edu.kz.HardwareStore.service.impl;

import sdu.edu.kz.HardwareStore.model.Order;
import sdu.edu.kz.HardwareStore.repository.OrderRepository;
import sdu.edu.kz.HardwareStore.service.OrderService;

//@Service
public class OrderServiceImpl implements OrderService {
//    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }
}