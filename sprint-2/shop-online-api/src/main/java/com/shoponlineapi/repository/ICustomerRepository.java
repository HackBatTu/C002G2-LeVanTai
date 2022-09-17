package com.shoponlineapi.repository;

import com.shoponlineapi.model.Customer;
import com.shoponlineapi.model.OrderService;
import javafx.scene.chart.ValueAxis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.* from customer c join app_user u on c.user_id = u.id where user_name = :userName",nativeQuery = true)
    Customer getCustomerByUserName(@Param("userName")String userName);

    @Query(value = "select c.* from customer c " +
            " join app_user u on c.user_id = u.id where c.is_deleted = 0 "
            ,countQuery = "select count(*) from (select c.* from customer c" +
            " join app_user u on c.user_id = u.id " +
            " where c.is_deleted = 0 ) temp_table ",nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);


    @Query(value = "select os.* from order_service os " +
            " join product p on p.id = os.product_id " +
            " join customer c on c.id = os.customer_id " +
            " join bill b on b.id = os.bill_id " +
            " where b.id = :id and os.is_deleted = 0 ",
            countQuery = " select count(*) from (select os.* from order_service os " +
            "             join product p on p.id = os.product_id " +
            "             join customer c on c.id = os.customer_id " +
            "            join bill b on b.id = os.bill_id " +
            "            where b.id = :id and os.is_deleted = 0 ) temp_table",nativeQuery = true)
    List<OrderService> findProductById(@Param("id") Integer id);
}
