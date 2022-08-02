package com.link.servie;

import com.link.model.Product;
import com.link.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAllProduct(Pageable pageable, String searchName) {
        return iProductRepository.findAllProduct(pageable, "%" + searchName + "%");
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        iProductRepository.deleteById(id);
    }
}
