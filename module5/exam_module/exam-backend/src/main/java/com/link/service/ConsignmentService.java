package com.link.service;

import com.link.model.Consignment;
import com.link.model.Product;
import com.link.repository.IConsignmentRepository;
import com.link.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsignmentService implements IConsignmentService{

    @Autowired
    private IConsignmentRepository iConsignmentRepository;

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Consignment> findAllConsignment(Pageable pageable, String productName, String dateCheckOut, String startDate, String endDate) {
        return iConsignmentRepository.findAllConsignment(pageable, "%" + productName + "%", "%" + dateCheckOut + "%", startDate, endDate);
    }
    @Override
    public List<Product> findAllProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public Page<Consignment> findAllConsignment(Pageable pageable) {
        return this.iConsignmentRepository.findAll(pageable);
    }

    @Override
    public Consignment save(Consignment consignment) {
       return iConsignmentRepository.save(consignment);
    }

    @Override
    public void delete(Integer id) {
        iConsignmentRepository.deleteById(id);
    }

    @Override
    public Consignment findById(Integer id) {
        return iConsignmentRepository.findById(id).orElse(null);
    }


}
