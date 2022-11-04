package com.phuong.dto;

import com.phuong.model.Bill;
import com.phuong.model.Customer;
import com.phuong.model.ProductOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class PaymentDto {
    private List<ProductOrder> productOrderList;
    private Customer customer;
    private Bill bill;
}
