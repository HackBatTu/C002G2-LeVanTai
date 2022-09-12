package com.shoponlineapi.service.impl;

import com.shoponlineapi.dto.IProductDTO;
import com.shoponlineapi.model.Product;
import com.shoponlineapi.repository.IProductRepository;
import com.shoponlineapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public void deleteProduct(Integer id) {
        iProductRepository.deleteProduct(id);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public List<Product> getSmartPhone() {
        return iProductRepository.getSmartPhone();
    }

    @Override
    public List<Product> getLaptop() {
        return iProductRepository.getLaptop();

    }

    @Override
    public List<Product> getTivi() {
        return iProductRepository.getTivi();
    }

    @Override
    public List<Product> getCamera() {
        return iProductRepository.getCamera();

    }

    @Override
    public List<Product> getDevice() {
        return iProductRepository.getDevice();

    }

    @Override
    public List<Product> getNewProducts() {
        return this.iProductRepository.getNewProducts();
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }


    @Override
    public Page<Product> findAllProduct(Pageable pageable, String id, String productName, String beginPrice, String endPrice, String originName) {
        Double begin = Double.valueOf(beginPrice);
        Double end = Double.valueOf(endPrice);
        if (id.equals("")) {
            id = "%%";
        }
        return this.iProductRepository.findAllProduct(pageable, id, "%" + productName + "%", begin, end, "%" + originName + "%");
    }

    @Override
    public Page<Product> getAllProduct(Pageable pageable,String searchByCategory, String searchByName, String searchByOrigin, String searchByStartPrice,String searchByEndPrice) {
        return iProductRepository.getAllProduct(pageable, "%"+ searchByCategory + "%", "%"+ searchByName + "%", "%"+ searchByOrigin + "%",searchByStartPrice,searchByEndPrice);
    }
}
