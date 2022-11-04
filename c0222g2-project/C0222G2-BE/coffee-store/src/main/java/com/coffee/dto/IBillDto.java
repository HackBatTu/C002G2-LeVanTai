package com.coffee.dto;

import java.util.Date;

public interface IBillDto {
    Integer getId();
    String getBillCode();
    Date getCreationDate();
    Boolean getIsDeleted();
    String getEmployeeName();
    String getCoffeeTableCode();
    Integer getDishOrderQuantity();
    String getDishName();
    Double getDishPrice();
    Double getTotalBill();
}
