package com.shoponlineapi.repository;

import com.shoponlineapi.model.Customer;
import com.shoponlineapi.model.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.* from customer c join app_user u on c.user_id = u.id where user_name = :userName",nativeQuery = true)
    Customer getCustomerByUserName(@Param("userName")String userName);

    @Query(value = "select c.* from customer c " +
            " join app_user u on c.user_id = u.id where c.is_deleted = 0 "
            ,countQuery = "select count(*) from (select c.* from customer c" +
            " join app_user u on c.user_id = u.id " +
            " where c.is_deleted = 0 ) temp_table ",nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);



}
