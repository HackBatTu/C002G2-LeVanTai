package com.link.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Room {
    @Id
    private String id;

    private Double area;
    private Double price;

    @Column(columnDefinition = "bit(1) default 0")
    private int status;

    @JsonBackReference
    @OneToOne(mappedBy = "room")
    private Contract contract;

    public Room() {
    }

    public Room(String id, Double area, Double price, int status, Contract contract) {
        this.id = id;
        this.area = area;
        this.price = price;
        this.status = status;
        this.contract = contract;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
