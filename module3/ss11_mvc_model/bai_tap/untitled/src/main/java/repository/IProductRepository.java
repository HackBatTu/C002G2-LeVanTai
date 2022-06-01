package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product product);

    void update(Integer id, Product product);

    void remove(Integer id);

    Product findById(Integer id);

}
