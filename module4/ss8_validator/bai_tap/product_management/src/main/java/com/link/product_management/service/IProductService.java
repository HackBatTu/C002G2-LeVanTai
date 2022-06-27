package com.link.product_management.service;

import com.link.product_management.model.Manufacturer;
import com.link.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    void save(Product product);

    Product findById(int id);

    void delete(int id);

    List<Manufacturer> getAllManufacturer();
}
