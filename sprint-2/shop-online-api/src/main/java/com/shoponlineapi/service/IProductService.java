package com.shoponlineapi.service;

import com.shoponlineapi.dto.IProductDTO;
import com.shoponlineapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {


    void deleteProduct(Integer id);

    Product findById(Integer id);

    void save(Product product);

    List<Product> getSmartPhone();

    List<Product> getLaptop();

    List<Product> getTivi();

    List<Product> getCamera();

    List<Product> getDevice();

    List<Product> getNewProducts();

    List<Product> findAll();

    Page<Product> findAllProduct(Pageable pageable, String categoryId, String productName, String beginPrice, String endPrice, String originName);


    Page<Product> getAllProduct(Pageable pageable,String searchByCategory, String searchByName, String searchByOrigin, String searchByStartPrice,String searchByEndPrice);
}
