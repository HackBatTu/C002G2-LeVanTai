package repository.impl;

import model.Product;
import repository.IProductRepository;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "xe bò",10.0, "màu xanh sang trọng","Lào"));
        products.put(2, new Product(2, "xe độp",20.0, "màu đen lấp lánh","Vin"));
        products.put(3, new Product(3, "xe công nông",30.0, "màu hường giả dối","VN"));
        products.put(4, new Product(4, "xe máy",40.0, "màu xanh bánh canh","Camp"));
        products.put(5, new Product(5, "xe ô tô",50.0, "màu lục như mục lục","sos"));
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
    public void update(Integer id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        products.remove(id);
    }

    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

}

