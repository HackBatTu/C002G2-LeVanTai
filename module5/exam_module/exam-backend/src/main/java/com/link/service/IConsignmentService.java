package com.link.service;

import com.link.model.Consignment;
import com.link.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IConsignmentService {
    Page<Consignment> findAllConsignment(Pageable pageable, String productName, String dateCheckOut, String startDate, String endDate);

    Consignment save(Consignment consignment);

    void delete(Integer id);

    Consignment findById(Integer id);

    List<Product> findAllProduct();

    Page<Consignment> findAllConsignment(Pageable pageable);
}
