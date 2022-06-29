package com.link.service;

import com.link.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product getById(int id);
}
