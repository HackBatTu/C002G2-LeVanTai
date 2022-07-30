package com.link.dto;

import com.link.model.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class ConsignmentDTO {
    private Integer id;
    @NotBlank
    @Pattern(regexp = "")
    private String codeProduct;
    private Integer quantity;
    private Date dateIn;
    private Date dateCheckIn;
    private Date dateCheckOut;
    private Product product;


}
