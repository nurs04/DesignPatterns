package sdu.edu.kz.HardwareStore.service.impl;

import org.springframework.stereotype.Service;
import sdu.edu.kz.HardwareStore.model.User;
import sdu.edu.kz.HardwareStore.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public boolean processPayment(User user, double amount) {
        // Simulate payment processing logic
        // For now, let's assume the payment always succeeds
        System.out.println("Processing payment of " + amount + " for user " + user.getName());
        return true;
    }
}
