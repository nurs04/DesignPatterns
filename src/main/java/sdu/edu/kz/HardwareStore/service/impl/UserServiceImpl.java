package sdu.edu.kz.HardwareStore.service.impl;

import sdu.edu.kz.HardwareStore.model.User;
import sdu.edu.kz.HardwareStore.repository.UserRepository;
import sdu.edu.kz.HardwareStore.service.UserService;

//@Service
public class UserServiceImpl implements UserService {
//    @Autowired
    private UserRepository userRepository;

//    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}