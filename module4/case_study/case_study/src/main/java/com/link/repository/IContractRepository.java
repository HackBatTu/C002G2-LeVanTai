package com.link.repository;

import com.link.model.contract.Contract;
import com.link.model.customer.Customer;
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

    @Query(value = " select * from contract where `status` = 0 and ( date_check_out between :dateIn and :dateOut ) ", nativeQuery = true,
    countQuery = " select count(*) from (select * from contract where `status` = 0 and ( date_check_out between :dateIn and :dateOut )) temp_table ")
    Page<Contract> findAllContract(Pageable pageable, @Param("dateIn") String dateIn, @Param("dateOut") String dateOut);

    @Modifying
    @Transactional
    @Query(value = "update contract c set status = 1 where c.id = :id ",nativeQuery = true)
    void deleteContract(Integer id);


    @Query(value = "select ct.* from contract ct " +
            "  join customer c on ct.customer_id = c.id " +
            "  join facility fa on ct.facility_id = fa.id " +
            "  join details_contract dct on dct.contract_id = ct.id " +
            "  join facility_attach afa on dct.facility_attach_id = afa.id " +
            " group by c.id , fa.id ",nativeQuery = true,
            countQuery = " select count(*) from (select c.* from customer c " +
                    "           join contract ct on ct.customer_id = c.id " +
                    "           join facility fa on ct.facility_id = fa.id " +
                    "           join details_contract dct on dct.contract_id = ct.id " +
                    "           join facility_attach afa on dct.facility_attach_id = afa.id " +
                    " group  by c.id, fa.id ) temp_table"
    )
    Page<Contract> findAllCustomerUsingService(Pageable pageable);


}
