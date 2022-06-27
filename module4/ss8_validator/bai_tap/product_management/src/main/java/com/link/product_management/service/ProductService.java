package com.link.product_management.service;

import com.link.product_management.model.Manufacturer;
import com.link.product_management.model.Product;
import com.link.product_management.repository.IManufacturerRepository;
import com.link.product_management.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    private IManufacturerRepository iManufacturerRepository;
    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(findById(id));
    }

    @Override
    public List<Manufacturer> getAllManufacturer() {
        return iManufacturerRepository.findAll();
    }
}
