package shoponlineapi.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import shoponlineapi.enlity.Bill;
import shoponlineapi.enlity.Customer;
import shoponlineapi.enlity.OrderService;

import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public class PaymentDto {
    private List<OrderService> productOrderList;
    private Customer customer;
    private Bill bill;
}
