package com.link.repository;

import com.link.dto.ConsignmentDTO;
import com.link.model.Consignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IConsignmentRepository extends JpaRepository<Consignment, Integer> {

    @Query(value = " select consignment.* from consignment join product on product.id = consignment.product_id " +
            " where product.name like :productName and date_check_out like :dateCheckOut and ( date_in between :startDate and :endDate ) " , nativeQuery = true,
    countQuery = " select count(*) from (select consignment.* from consignment join product on product.id = consignment.product_id " +
            " where product.name like :productName and date_check_out like :dateCheckOut and ( date_in between :startDate and :endDate)) temp_table ")
    Page<Consignment> findAllConsignment(Pageable pageable, @Param("productName") String productName,
                                         @Param("dateCheckOut") String dateCheckOut, String startDate, String endDate);

}
