package service;

import model.Category;
import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.getAllProduct();
    }

    @Override
    public List<Category> getAllCategory() {
        return iProductRepository.getAllCategory();
    }

    @Override
    public void insert(Product product) {
        iProductRepository.insert(product);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepository.updateProduct(product);

    }

    @Override
    public Product findById(int idEdit) {
        return  iProductRepository.findById(idEdit);
    }

    @Override
    public void delete(int id) {
       iProductRepository.delete(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return  iProductRepository.searchByName(name);
    }
}
