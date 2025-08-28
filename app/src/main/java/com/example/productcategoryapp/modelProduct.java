package com.example.productcategoryapp;

import java.io.Serializable;

public class modelProduct implements Serializable {
    private String name;
    private String description;
    private String price;
    private String expiry_date;

    public modelProduct(String name, String description, String price, String expiry_date) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}
