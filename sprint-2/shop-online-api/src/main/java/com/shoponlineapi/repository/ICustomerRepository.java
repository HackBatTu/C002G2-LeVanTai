package com.shoponlineapi.repository;

import com.shoponlineapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.* from customer c join app_user u on c.user_id = u.id where user_name = :userName",nativeQuery = true)
    Customer getCustomerByUserName(@Param("userName")String userName);
}
