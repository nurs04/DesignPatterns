package sdu.edu.kz.HardwareStore.model;

import lombok.*;


public class User {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String gender;
    private String city;
    private String address;
    private String phone;
    private String birthday;

    public String getUsername() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}