package com.example.productcategoryapp;

import java.time.LocalDate;
import java.util.Date;

public class modelProduct {

    int id;
    String name;
    String description;
    float price;
    LocalDate expery_date;

    public modelProduct(int id, String name, String description, float price, LocalDate expery_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expery_date = expery_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getExpery_date() {
        return expery_date;
    }

    public void setExpery_date(LocalDate expery_date) {
        this.expery_date = expery_date;
    }
}
