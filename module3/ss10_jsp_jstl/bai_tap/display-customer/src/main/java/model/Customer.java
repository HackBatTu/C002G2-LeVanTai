package model;

import java.util.Date;

public class Customer {
    private String name;
    private String date;
    private String address;
    private String picture;

    public Customer(String name, String date, String address, String picture) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.picture = picture;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
