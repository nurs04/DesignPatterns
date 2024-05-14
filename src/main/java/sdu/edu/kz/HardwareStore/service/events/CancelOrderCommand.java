package sdu.edu.kz.HardwareStore.service.events;

import sdu.edu.kz.HardwareStore.service.OrderService;
import sdu.edu.kz.HardwareStore.service.patterns.OrderCommand;

public class CancelOrderCommand implements OrderCommand {
    private OrderService orderService;
    private Long orderId;

    public CancelOrderCommand(OrderService orderService, Long orderId) {
        this.orderService = orderService;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        orderService.cancelOrder(orderId);
    }
}
