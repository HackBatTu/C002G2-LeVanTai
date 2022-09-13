package com.shoponlineapi.repository;

import com.shoponlineapi.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBillRepository extends JpaRepository<Bill, Integer> {

    @Query(value = " select * from bill where code = :randomCode ", nativeQuery = true)
    Bill getBillByCode(@Param("randomCode") int randomCode);
}
