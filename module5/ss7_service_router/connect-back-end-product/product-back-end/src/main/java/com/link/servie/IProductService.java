package com.link.servie;

import com.link.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllProduct(Pageable pageable, String searchName);

    Product findById(Integer id);

    Product save(Product product);

    void deleteById(Integer id);
}
