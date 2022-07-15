package com.link.repository;

import com.link.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IContractRepository extends JpaRepository<Contract , String> {

    @Query(value = "select * from contract where status = 0", nativeQuery = true)
    List<Contract> findAllContract();

    @Modifying
    @Transactional
    @Query(value = "update contract c set status = 1 where c.id = :id ",nativeQuery = true)
    void deleteByIdContract(String id);
}
