package com.link.repository;

import com.link.model.Consignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsignmentRepository extends JpaRepository<Consignment, Integer> {

    @Query(value = "select consignment.* from consignment join product on product.id = consignment.product_id " +
            " where product.name like :productName and date_check_out like :dateCheckOut and date_in between :startDate and :endDate",nativeQuery = true,
    countQuery = "select count(*) from (select consignment.* from consignment join product on product.id = consignment.product_id " +
            " where product.name like :productName and date_check_out like :dateCheckOut and date_in between :startDate and :endDate) temp_table")
    Page<Consignment> findAll(Pageable pageable, String productName, String dateCheckOut, String startDate, String endDate);
}
