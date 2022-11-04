package com.phuong.dto;

import com.phuong.model.account.AppUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class CustomerDto {
    private Integer id;

    private String name;

    private String phoneNumber;

    private String address;

    private String image;

    private Boolean isDeleted;

    private String email;

    private Date birthday;

    private AppUser appUser;
}
