package com.link.dto;

import com.link.model.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

public class ConsignmentDTO {
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^(LH-)([0-9]{4})$")
    private String codeProduct;
    @PositiveOrZero
    private Integer quantity;
    @NotBlank
    private String dateIn;
    @NotBlank
    private String dateCheckIn;
    @NotBlank
    private String dateCheckOut;
    private Product product;

    public ConsignmentDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(String dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public String getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(String dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ConsignmentDTO(Integer id, String codeProduct, Integer quantity, String dateIn, String dateCheckIn, String dateCheckOut, Product product) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.quantity = quantity;
        this.dateIn = dateIn;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.product = product;
    }
}
