package com.shoponlineapi.service;

import com.shoponlineapi.dto.IProductDTO;
import com.shoponlineapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<IProductDTO> getAllProduct(Pageable pageable, String searchByName, String searchByOrigin, String searchByPrice);

    List<Product> getAllPro();

    void deleteProduct(Integer id);

    Product findById(Integer id);

    void save(Product product);

    List<Product> getSmartPhone();

    List<Product> getLaptop();

    List<Product> getTivi();

    List<Product> getCamera();

    List<Product> getDevice();
}
