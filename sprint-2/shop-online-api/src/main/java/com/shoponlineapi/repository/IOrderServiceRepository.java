package com.shoponlineapi.repository;

import com.shoponlineapi.model.Customer;
import com.shoponlineapi.model.OrderService;
import com.shoponlineapi.service.impl.OrderServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderServiceRepository extends JpaRepository<OrderService, Integer> {
    @Query(value = " select po.* from order_service po " +
            " join customer c on c.id = po.customer_id " +
            " join product p on p.id = po.product_id " +
            " where po.customer_id = :#{#orderService.customer.id} and po.product_id = :#{#orderService.product.id} and po.bill_id is null ", nativeQuery = true)
    OrderService findProductOrderListByCustomerAndProduct(OrderService orderService);

    @Query(value = " select po.* from product_order po " +
            " join customer c on c.id = po.customer_id " +
            " join product p on p.id = po.product_id " +
            " where po.customer_id = :#{#customer.id} and bill_id is null ", nativeQuery = true)
    List<OrderService> getProductInCardByCustomer(Customer customer);
}
