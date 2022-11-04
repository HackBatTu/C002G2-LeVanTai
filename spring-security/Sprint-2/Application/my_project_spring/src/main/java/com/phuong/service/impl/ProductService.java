package com.phuong.service.impl;

import com.phuong.model.Product;
import com.phuong.repository.IProductRepository;
import com.phuong.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getNewProducts() {
        return this.productRepository.getNewProducts();
    }

    @Override
    public void save(Product product) {
        product.setIsDeleted(false);
        product.setReleaseTime(new Date(System.currentTimeMillis()));
        this.productRepository.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable, String id, String productName, String beginPrice, String endPrice, String originName) {
        Double begin = Double.valueOf(beginPrice);
        Double end = Double.valueOf(endPrice);
        if (id.equals("")) {
            id = "%%";
        }
        return this.productRepository.findAll(pageable, id, "%" + productName + "%", begin, end, "%" + originName + "%");
    }

    @Override
    public Product findById(String id) {
        return this.productRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @Override
    public List<Product> findByCategoryId(Integer id) {
        return this.productRepository.findByCategoryId(id);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAllListProduct();
    }

    @Override
    public Boolean deleteProduct(String id) {
        List<Product> productList = this.productRepository.findAll();
        for (Product product : productList) {
            if (product.getId().equals(Integer.parseInt(id)) && !product.getIsDeleted()) {
                this.productRepository.deleteProduct(id);
                return true;
            }
        }
        return false;
    }
}
