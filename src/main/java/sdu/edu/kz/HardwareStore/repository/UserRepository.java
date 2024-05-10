package sdu.edu.kz.HardwareStore.repository;

import sdu.edu.kz.HardwareStore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}