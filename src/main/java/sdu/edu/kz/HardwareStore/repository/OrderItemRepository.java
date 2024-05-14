package sdu.edu.kz.HardwareStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdu.edu.kz.HardwareStore.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}