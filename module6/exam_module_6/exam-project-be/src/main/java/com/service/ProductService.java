package com.service;

import com.model.Product;
import com.model.ProductType;
import com.repository.IProductRepository;
import com.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    private IProductTypeRepository iProductTypeRepository;

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return iProductRepository.findAllProduct(pageable);
    }

    @Override
    public List<ProductType> getAllProductType() {
        return iProductTypeRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        iProductRepository.deleteProduct(id);
    }

    @Override
    public List<Product> finAll() {
        return iProductRepository.findAll();
    }
}
