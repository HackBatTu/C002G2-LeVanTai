package com.phuong.repository;

import com.phuong.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = " select c.* from customer c " +
            " join app_user au on au.id = c.user_id " +
            " where user_name = :username ", nativeQuery = true)
    Customer getCustomerByUsername(@Param("username") String username);
}
