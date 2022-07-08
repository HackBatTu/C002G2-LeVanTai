package com.link.repository;

import com.link.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract where status = 0 and between date_check_in and date_check_out ", nativeQuery = true,
    countQuery = "select count(*) from (select * from contract where status = 0)")
    Page<Contract> findAllContract(@Param("searchDate") String searchDate, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update contract c set status = 1 where c.id = :id ",nativeQuery = true)
    void deleteContract(Integer id);
}
