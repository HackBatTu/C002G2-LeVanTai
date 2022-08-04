package com.link.controller;

import com.link.model.Category;
import com.link.model.Product;
import com.link.servie.ICategoryService;
import com.link.servie.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/rest")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/product")
    public ResponseEntity<Page<Product>> getAllProduct(@PageableDefault(3) Pageable pageable,
                                                       Optional<String> search) {
        String searchName = search.orElse("");
        Page<Product> productPage = iProductService.findAllProduct(pageable, searchName);
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categoryList = iCategoryService.getAllCategory();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(iProductService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Product> findByID(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iProductService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        return new ResponseEntity<>(iProductService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        this.iProductService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
