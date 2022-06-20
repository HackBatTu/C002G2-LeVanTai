package com.link.model;

public class Product {
    private int id;
    private String name;
    private double prince;
    private String describe;
    private String manufacture;

    public Product() {
    }

    public Product(int id, String name, double prince, String describe, String manufacture) {
        this.id = id;
        this.name = name;
        this.prince = prince;
        this.describe = describe;
        this.manufacture = manufacture;
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

    public double getPrince() {
        return prince;
    }

    public void setPrince(double prince) {
        this.prince = prince;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
