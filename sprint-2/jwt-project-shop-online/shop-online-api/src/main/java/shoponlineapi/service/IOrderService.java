package shoponlineapi.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shoponlineapi.dto.ErrorDTO;
import shoponlineapi.dto.PaymentDto;
import shoponlineapi.enlity.Customer;
import shoponlineapi.enlity.OrderService;

import java.util.List;

public interface IOrderService {
    ErrorDTO saveOrder(OrderService productOrder);

    List<OrderService> getProductInCardByCustomer(Customer customer);

    Boolean minusQuantity(OrderService orderService);

    Boolean plusQuantity(OrderService orderService);

    Boolean findProductOrder(OrderService orderService);

    PaymentDto goPayment(Customer customer);


    Page<OrderService> findAll(Pageable pageable);

    Page<OrderService> getListOrderYesterday(Pageable pageable);

    Page<OrderService> getOrderInCustomer(Pageable pageable, Customer customer);
}
