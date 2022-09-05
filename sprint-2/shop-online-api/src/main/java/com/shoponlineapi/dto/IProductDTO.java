package com.shoponlineapi.dto;

public interface IProductDTO {
    Integer getId();
    String getName();
    String getImage();
    Double getPrice();
    String getOrigin();
    Integer getAmount();
    String getSpecification();
    String getDescription();
    Boolean getIsDeleted();
    String getCategory();
}
