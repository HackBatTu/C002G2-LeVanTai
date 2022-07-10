//package com.link.repository;
//
//import com.link.model.customer.CustomerUsingServiceDTO;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ICustomerServiceDTO extends JpaRepository<CustomerUsingServiceDTO, Integer> {
//    @Query(value = "select c.id,c.name,c.phone,c.address,c.email,fa.id,fa.name,afa.name from customer c " +
//            " join contract ct on ct.customer_id = c.id " +
//            " join facility fa on ct.facility_id = fa.id " +
//            " join details_contract dct on dct.contract_id = ct.id " +
//            " join facility_attach afa on afa.id = dct.facility_attach_id ",nativeQuery = true)
//    List<CustomerUsingServiceDTO> findAllCustomerUsingServiceDTO();
//}
