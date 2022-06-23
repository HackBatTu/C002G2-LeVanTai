package com.link.productspringboot.service;

import com.link.productspringboot.model.Product;
import com.link.productspringboot.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;

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


}
