package com.example.assignmentone;

import java.util.ArrayList;
import java.util.Arrays;

public class Makeup {

    private String Brand;
    private String Category;
    private String  Name;
    private double Price ;
    private int imageId;
    private ArrayList<Makeup> makeups;
    public ArrayList<Makeup> getMakeups() {
        return makeups;
    }

    public void setMakeups(ArrayList<Makeup> makeups) {
        this.makeups = makeups;
    }



    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Makeup(String brand, String category, String name, double price,int imageId) {
        Brand = brand;
        Category = category;
        this.imageId = imageId;
        Name = name;
        Price = price;
    }

    public Makeup() {
    }

}
