package sdu.edu.kz.HardwareStore.service.events;

import sdu.edu.kz.HardwareStore.model.Order;
import sdu.edu.kz.HardwareStore.service.OrderService;
import sdu.edu.kz.HardwareStore.service.patterns.OrderCommand;

public class UpdateOrderCommand implements OrderCommand {
    private OrderService orderService;
    private Order order;

    public UpdateOrderCommand(OrderService orderService, Order order) {
        this.orderService = orderService;
        this.order = order;
    }

    @Override
    public void execute() {
        orderService.updateOrder(order);
    }
}

