package service;

import model.Category;
import model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> getAllProduct();

    List<Category> getAllCategory();

    Map<String, String> insert(Product product);

    Map<String, String> updateProduct(Product product);

    Product findById(int idEdit);

    void delete(int id);

    List<Product> searchByName(String name);
}
