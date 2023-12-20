package com.coursework.eshop.model;

public class Review extends Comment {
    private double rating;

    private Product product;

    public Review(String commentTitle, String commentBody, double rating, Product product) {
        super(commentTitle, commentBody);
        this.rating = rating;
        this.product = product;
    }



}
