package com.link.repository;

import com.link.model.customer.Customer;
import com.link.model.customer.CustomerUsingServiceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where status = 0 and name like :searchName", nativeQuery = true,
    countQuery = " select count(*) from (select * from customer where status = 0 and name like :searchName) temp_table")
    Page<Customer> findAllCustomer(@Param("searchName") String searchName, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update customer c set status = 1 where c.id= :id", nativeQuery = true)
    void deleteCustomer(Integer id);

    @Query(value = "select * from customer where status = 0", nativeQuery = true)
    List<Customer> getAllCustomer();


}
