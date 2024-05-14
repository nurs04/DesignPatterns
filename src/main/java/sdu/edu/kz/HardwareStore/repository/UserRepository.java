package sdu.edu.kz.HardwareStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdu.edu.kz.HardwareStore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}