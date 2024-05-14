package sdu.edu.kz.HardwareStore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


        //Here we use Builder Pattern for optimizing and clean code(Handle problems)
        User.UserBuilder userBuilder = User.builder()
                .name(name)
                .password(password)
                .email(email);

        userBuilder.surname(surname);

        User user = userBuilder.build();

        if (password.equals(confPassword)) {
            if (userService.findByUsername(user.getUsername()) != null) {
                redirect = "redirect:/auth/?accountExist";
            } else {
                User newUser = userService.addUser(user);
                if (newUser != null) {
                    redirect = "redirect:/auth/?afterRegistration";
                } else {
                    redirect = "redirect:/auth/register/?error";
                }
            }
        } else {
            redirect = "redirect:/auth/register/?notEqualPasswords";
        }
        return redirect;
    }
}