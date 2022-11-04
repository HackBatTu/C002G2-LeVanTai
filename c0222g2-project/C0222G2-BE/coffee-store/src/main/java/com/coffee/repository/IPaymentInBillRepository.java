package com.coffee.repository;

import com.coffee.model.bill.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IPaymentInBillRepository extends JpaRepository<Bill, Integer> {

    @Transactional
    @Modifying
    @Query(value = " INSERT INTO `bill` (`code`, `creation_date`) VALUES (:#{#bill.code}, :#{#bill.creationDate}); ",
            nativeQuery = true)
    void createCodeBill(Bill bill);
}
