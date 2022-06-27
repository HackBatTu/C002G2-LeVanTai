package com.link.product_management.dto;

import com.link.product_management.model.Manufacturer;

import javax.validation.constraints.*;

public class ProductDTO {
    private int id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;
    @NotNull
    @PositiveOrZero
//    @Pattern(regexp = "[0-9]+(\\.)[0-9]+")
    private Double price;
    @NotNull
    @NotBlank
    @NotEmpty
    private String color;
    @NotNull
    private Manufacturer manufacturer;

    public ProductDTO(int id, String name, Double price, String color, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.manufacturer = manufacturer;
    }

    public ProductDTO() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
