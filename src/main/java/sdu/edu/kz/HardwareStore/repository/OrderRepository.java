package sdu.edu.kz.HardwareStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdu.edu.kz.HardwareStore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}