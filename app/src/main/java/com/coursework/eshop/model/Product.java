package com.coursework.eshop.model;


import java.io.Serializable;
import java.util.List;


public class Product implements Serializable {
    int id;
    String title;
    String description;
    String manufacturer;

    public Product(String title, String description) {
        this.title = title;
        this.description = description;
    }


}
