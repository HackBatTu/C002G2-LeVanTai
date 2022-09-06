package com.shoponlineapi.dto;

import com.shoponlineapi.model.Category;
import lombok.Data;


@Data
public class ProductDTO {
    private Integer id;
    private String image;
    private String name;
    private double price;
    private String origin;
    private String specification;
    private String description;
    private Integer amount;
    private Category category;
    private Boolean isDeleted;
}
