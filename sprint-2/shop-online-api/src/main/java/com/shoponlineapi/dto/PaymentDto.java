package com.shoponlineapi.dto;

import com.shoponlineapi.model.Bill;
import com.shoponlineapi.model.Customer;
import com.shoponlineapi.model.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public class PaymentDto {
    private List<OrderService> productOrderList;
    private Customer customer;
    private Bill bill;
}
