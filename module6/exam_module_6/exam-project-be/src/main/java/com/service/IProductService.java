package com.service;

import com.model.Product;
import com.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> getAllProduct(Pageable pageable);

    List<ProductType> getAllProductType();

    void save(Product product);

    void deleteById(Integer id);

    List<Product> finAll();
}
