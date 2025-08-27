package com.example.productcategoryapp;

import java.time.LocalDate;

public class modelProduct {

    int id;
    String name;
    String description;
    float price;
    LocalDate expiry_date;

    public modelProduct( String name, String description, float price, LocalDate expiry_date) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.expiry_date = expiry_date;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    public void setExpery_date(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }
}
