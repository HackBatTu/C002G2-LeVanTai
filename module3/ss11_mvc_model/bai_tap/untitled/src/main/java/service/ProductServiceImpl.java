package service;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl {
    IProductRepository productRepository = new ProductRepository();

    public List<Product> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

}
