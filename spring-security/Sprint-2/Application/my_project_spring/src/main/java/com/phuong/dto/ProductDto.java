package com.phuong.dto;

import com.phuong.model.Category;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDto {

    private Integer id;

    private String name;

    private Date releaseTime;

    private Date manufactureTime;

    private String origin;

    private Double price;

    private String warrantyPeriod;

    private Integer quantity;

    private Double discountPercent;

    private String specifications;

    private String description;

    private String image;

    private Boolean isDeleted;

    private Category category;
}
