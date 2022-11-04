package com.phuong.dto;

import com.phuong.model.ProductOrder;
import lombok.Data;

import java.util.List;

@Data
public class ErrorDto {
    private String message;
    private List<String> messageList;
    private ProductOrder productOrder;
}
