package sdu.edu.kz.HardwareStore.service;

import sdu.edu.kz.HardwareStore.model.User;

public interface UserService {
    User register(User user);
    User findByUsername(String username);
    User addUser(User user);
}
