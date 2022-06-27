package com.link.productspringboot.service;

import com.link.productspringboot.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    void save(Product product);

    Product findById(int id);

    void delete(int id);
}
