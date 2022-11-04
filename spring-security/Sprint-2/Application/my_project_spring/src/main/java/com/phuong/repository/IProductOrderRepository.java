package com.phuong.repository;

import com.phuong.model.Bill;
import com.phuong.model.Customer;
import com.phuong.model.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    @Query(value = " select po.* from product_order po " +
            " join customer c on c.id = po.customer_id " +
            " join product p on p.id = po.product_id " +
            " where po.customer_id = :#{#productOrder.customer.id} and po.product_id = :#{#productOrder.product.id} and po.bill_id is null ", nativeQuery = true)
    ProductOrder findProductOrderListByCustomerAndProduct(ProductOrder productOrder);

    @Query(value = " select po.* from product_order po " +
            " join customer c on c.id = po.customer_id " +
            " join product p on p.id = po.product_id " +
            " where po.customer_id = :#{#customer.id} and bill_id is null ", nativeQuery = true)
    List<ProductOrder> getProductInCardByCustomer(Customer customer);

    @Modifying
    @Transactional
    @Query(value = " UPDATE `product_order` SET `bill_id` = :billId WHERE (`customer_id` = :customerId) and `bill_id` is null ", nativeQuery = true)
    void setBill(@Param("customerId") Integer customerId,@Param("billId") Integer billId);

    @Query(value = " select po.id, po.is_deleted,po.bill_id, po.customer_id, po.product_id, count(po.quantity) as quantity from bill " +
            " join product_order po on bill.id = po.bill_id " +
            " where po.customer_id = :#{#customer.id} " +
            " group by po.product_id ", nativeQuery = true,
            countQuery = " select po.id, po.is_deleted,po.bill_id, po.customer_id, po.product_id, count(po.quantity) as quantity from bill " +
                    "join product_order po on bill.id = po.bill_id " +
                    "where po.customer_id = :#{#customer.id} " +
                    "group by po.product_id ")
    Page<ProductOrder> findProductOrderByCustomer(Pageable pageable, Customer customer);
}
