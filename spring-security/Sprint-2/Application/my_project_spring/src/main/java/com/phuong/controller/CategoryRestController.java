package com.phuong.controller;

import com.phuong.model.Category;
import com.phuong.model.Product;
import com.phuong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/categories")
public class CategoryRestController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/page")
    public ResponseEntity<Page<Category>> getAllCategoryPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "3") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Category> categoryPage = this.categoryService.findAll(pageable);
        for (Category category: categoryPage.getContent()) {
            int totalProduct = 0;
            for (Product product: category.getProductList()) {
                if (!product.getIsDeleted()) {
                    totalProduct++;
                }
            }
            category.setTotalProduct(totalProduct);
        }
        if (categoryPage.hasContent()) {
            return new ResponseEntity<>(categoryPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categoryList = this.categoryService.findAll();
        for (Category category: categoryList) {
            int totalProduct = 0;
            for (Product product: category.getProductList()) {
                if (!product.getIsDeleted()) {
                    totalProduct++;
                }
            }
            category.setTotalProduct(totalProduct);
        }
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    @GetMapping(value = "/discount")
    public ResponseEntity<List<Category>> getAllCategoryDiscount() {
        List<Category> categoryList = this.categoryService.getCategoryDiscount();
        for (Category category: categoryList) {
            category.setTotalProduct(category.getProductList().size());
        }
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
