package com.link.service;

import com.link.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Car",100.0, "black , 4s", "Vinfast"));
        products.put(2, new Product(2, "Truck",200.0, "white , 2s", "mescedes"));
        products.put(3, new Product(3, "Moto",50.0, "spring , 2s", "honda"));
        products.put(4, new Product(4, "Moto",30.0, "vcs, 3s ,black", "Đông lào"));
        products.put(5, new Product(5, "bike",15.0, "green , 3s ,lck", "Đông lào"));
        products.put(6, new Product(6, "Car",120.0, "sos , 5s , red", "Vinfast"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for(Product product : products.values()){
            if(product.getName().contains(name)){
                productList.add(product);
            }
        }
        return productList;
    }
    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }


}
