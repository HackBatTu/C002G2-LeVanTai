package com.shoponlineapi.dto;



import java.util.Date;

public interface CustomerTopDTO {
    Integer getQuantity();

    String getName();

    String getPhone();

    String getAddress();

    String getImage();

    String getEmail();

    Date getBirthday();

    String getUserName();
}
