package sdu.edu.kz.HardwareStore.controller;

import org.springframework.web.bind.annotation.*;
import sdu.edu.kz.HardwareStore.model.Order;
import sdu.edu.kz.HardwareStore.service.OrderService;
import sdu.edu.kz.HardwareStore.service.events.CancelOrderCommand;
import sdu.edu.kz.HardwareStore.service.events.CreateOrderCommand;
import sdu.edu.kz.HardwareStore.service.events.UpdateOrderCommand;
import sdu.edu.kz.HardwareStore.service.patterns.OrderCommand;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order) {
        OrderCommand command = new CreateOrderCommand(orderService, order);
        command.execute();
    }

    @PutMapping("/update")
    public void updateOrder(@RequestBody Order order) {
        OrderCommand command = new UpdateOrderCommand(orderService, order);
        command.execute();
    }

    @DeleteMapping("/cancel/{orderId}")
    public void cancelOrder(@PathVariable Long orderId) {
        OrderCommand command = new CancelOrderCommand(orderService, orderId);
        command.execute();
    }
}