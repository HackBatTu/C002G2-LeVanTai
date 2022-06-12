package service;

import model.Category;
import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, String> insert(Product product) {
        Map<String, String> errors = new HashMap<>();
        List<Category> categoryList = iProductRepository.getAllCategory();
        boolean flag = false;
        for (Category category : categoryList) {
            if (product.getCategory().getId() == category.getId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errors.put("category", "xl đi b ơi ! đừng f12!");
        }
        if(product.getName().equals("")||product.getName()== null){
            errors.put("name","nhập dữ liệu đi bạn ơi");
        }
        if(product.getColor().equals("")||product.getColor()== null){
            errors.put("color","nhập dữ liệu đi bạn ơi");
        }
        if(errors.isEmpty()){
            iProductRepository.insert(product);
        }
        return errors;
    }

    @Override
    public Map<String, String> updateProduct(Product product) {
        Map<String, String> errors = new HashMap<>();
        List<Category> categoryList = iProductRepository.getAllCategory();
        boolean flag = false;
        for (Category category : categoryList) {
            if (product.getCategory().getId() == category.getId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errors.put("category", "xl đi b ơi ! đừng f12!");
        }
        if(product.getName().equals("")||product.getName()== null){
            errors.put("name","nhập dữ liệu đi bạn ơi");
        }
        if(product.getColor().equals("")||product.getColor()== null){
            errors.put("color","nhập dữ liệu đi bạn ơi");
        }
        if(errors.isEmpty()){
            iProductRepository.updateProduct(product);
        }
        return errors;
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
