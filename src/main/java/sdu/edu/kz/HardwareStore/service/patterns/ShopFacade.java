package sdu.edu.kz.HardwareStore.service.patterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.edu.kz.HardwareStore.model.Order;
import sdu.edu.kz.HardwareStore.model.OrderItem;
import sdu.edu.kz.HardwareStore.model.Product;
import sdu.edu.kz.HardwareStore.model.User;
import sdu.edu.kz.HardwareStore.service.OrderService;
import sdu.edu.kz.HardwareStore.service.PaymentService;
import sdu.edu.kz.HardwareStore.service.ProductService;

@Service
public class ShopFacade {
    private final ProductService productService;
    private final OrderService orderService;
    private final PaymentService paymentService;

    public ShopFacade(ProductService productService, OrderService orderService, PaymentService paymentService) {
        this.productService = productService;
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    @Transactional
    public boolean placeOrder(User user, Long productId, int quantity) {
        Product product = productService.getProductById(productId);
        if (product != null && product.getStock() >= quantity) {
            double totalPrice = product.getPrice() * quantity;
            boolean paymentConfirmed = paymentService.processPayment(user, totalPrice);
            if (paymentConfirmed) {
                Order order = new Order(user.getId());
                OrderItem orderItem = new OrderItem(productId, quantity, product.getPrice());
                order.addOrderItem(orderItem);
                orderService.saveOrder(order);
                return true;
            }
        }
        return false;
    }
}
