package sdu.edu.kz.HardwareStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdu.edu.kz.HardwareStore.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
