package sdu.edu.kz.HardwareStore.controller;

import lombok.RequiredArgsConstructor;
import sdu.edu.kz.HardwareStore.model.User;
import sdu.edu.kz.HardwareStore.security.SecurityConfig;
import sdu.edu.kz.HardwareStore.service.impl.UserServiceImpl;

@Controller
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {


    private final UserServiceImpl userService;
    private final SecurityConfig securityConfig;

    @GetMapping
    public String loginPage() {
        return "login";
    }


    @GetMapping(value = "/register")
    public String registerPage() {
        return "register";
    }


    @PostMapping(value = "/register")
    public String registerPage(@RequestParam(name = "reg_email") String email,
                               @RequestParam(name = "reg_password") String password,
                               @RequestParam(name = "reg_confPassword") String confPassword,
                               @RequestParam(name = "name") String name,
                               @RequestParam(name = "surname") String surname) {
        String redirect = "";

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(securityConfig.passwordEncoder().encode(password));

        if (password.equals(confPassword)) {
            if (userService.addUser(user)) {
                redirect = "redirect:/auth/?afterRegistration";
            } else {
                redirect = "redirect:/auth/?accountExist";
            }
        } else {
            redirect = "redirect:/auth/register/?notEqualPasswords";
        }

        return redirect;
    }
    }
}