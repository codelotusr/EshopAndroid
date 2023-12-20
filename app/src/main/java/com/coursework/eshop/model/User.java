package com.coursework.eshop.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public abstract class User implements Serializable {
    int id;
    String username;
    String password;
    LocalDate birthDate;
    String firstName;
    String lastName;
    String role;

    public User(String login, String password, LocalDate birthDate, String name, String surname, String role) {
        this.username = login;
        this.password = password;
        this.birthDate = birthDate;
        this.firstName = name;
        this.lastName = surname;
        this.role = role;
    }

    public User(int id, String login, String password, LocalDate birthDate) {
        this.id = id;
        this.username = login;
        this.password = password;
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
