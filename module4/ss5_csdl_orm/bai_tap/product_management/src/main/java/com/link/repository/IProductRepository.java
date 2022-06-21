package com.link.repository;


import com.link.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();

    void save(Product product);

    Product findById(int id);

    void delete(int id);

    void edit(Product product);

    List<Product> getProductByName(String search);
}