package com.link.dto;

import com.link.model.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class ConsignmentDTO {
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^(LH-)([0-9]{4})$")
    private String codeProduct;
    @PastOrPresent
    private Integer quantity;
    @NotBlank
    private Date dateIn;
    @NotBlank
    private Date dateCheckIn;
    @NotBlank
    private Date dateCheckOut;
    private Product product;

    public ConsignmentDTO() {
    }

    public ConsignmentDTO(Integer id, String codeProduct, Integer quantity, Date dateIn, Date dateCheckIn, Date dateCheckOut, Product product) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.quantity = quantity;
        this.dateIn = dateIn;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.product = product;
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

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Date getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
