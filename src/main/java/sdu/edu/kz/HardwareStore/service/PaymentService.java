package sdu.edu.kz.HardwareStore.service;

import sdu.edu.kz.HardwareStore.model.User;

public interface PaymentService {
    boolean processPayment(User user, double amount);
}