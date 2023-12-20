package com.coursework.eshop.model;

import java.time.LocalDate;



public class Customer extends User {
    private String address;
    private String cardNo;


    public Customer(String login, String password, LocalDate birthDate, String name, String surname, String address, String cardNo, String role) {
        super(login, password, birthDate, name, surname, role);
        this.address = address;
        this.cardNo = cardNo;
    }



}
