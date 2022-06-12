package service;

import model.Category;
import model.Product;

import java.util.LinkedHashMap;
import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    List<Category> getAllCategory();

    void insert(Product product);

    void updateProduct(Product product);

    Product findById(int idEdit);

    void delete(int id);

    List<Product> searchByName(String name);
}
