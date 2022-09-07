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
    public Page<IProductDTO> getAllProduct(Pageable pageable, String searchByName, String searchByOrigin, String searchByPrice) {
        return iProductRepository.getAllProduct(pageable, "%"+ searchByName + "%", "%"+ searchByOrigin + "%","%"+ searchByPrice + "%");
    }

    @Override
    public List<Product> getAllPro() {
        return iProductRepository.findAll();
    }

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
}
