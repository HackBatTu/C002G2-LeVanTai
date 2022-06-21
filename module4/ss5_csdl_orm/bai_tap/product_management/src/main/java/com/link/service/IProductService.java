package com.link.service;

import com.link.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductService {

    List<Product> getAllProduct();

    void save(Product product);

    Product findById(int id);

    void delete(int id);

    void edit(Product product);

    List<Product> getProductByName(String search);
}