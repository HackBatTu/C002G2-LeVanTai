package shoponlineapi.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shoponlineapi.enlity.Product;

import java.util.List;

public interface IProductService {


    Boolean deleteProduct(String id);

    Product findById(Integer id);

    void save(Product product);

    List<Product> getSmartPhone();

    List<Product> getLaptop();

    List<Product> getTivi();

    List<Product> getCamera();

    List<Product> getDevice();

    List<Product> getNewProducts();

    List<Product> findAll();

    Page<Product> getAllProduct(Pageable pageable,String searchByCategory, String searchByName, String searchByOrigin, String searchByStartPrice,String searchByEndPrice);
}
