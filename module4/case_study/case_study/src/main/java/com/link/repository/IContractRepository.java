package com.link.repository;

import com.link.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract where status = 0", nativeQuery = true,
    countQuery = "select count(*) from (select * from contract where status = 0)")
    Page<Contract> findAllContract(Pageable pageable);
}
