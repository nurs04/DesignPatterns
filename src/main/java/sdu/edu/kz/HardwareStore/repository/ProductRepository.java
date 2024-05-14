package sdu.edu.kz.HardwareStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdu.edu.kz.HardwareStore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}