package sdu.edu.kz.HardwareStore.model;

import lombok.*;

@Builder
public class User {
    @Getter
    private String id;
    @Getter
    private String name;
    private String surname;
    private String email;
    @Getter
    private String password;
    private String gender;
    private String city;
    private String address;
    private String phone;
    private String birthday;

    public String getUsername() {
        return email;
    }

}