package com.phuong.service.impl;

import com.phuong.model.Category;
import com.phuong.repository.ICategoryRepository;
import com.phuong.service.ICategoryService;
import com.phuong.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IProductService productService;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return this.categoryRepository.getAllCategory(pageable);
    }

    @Override
    public List<Category> getCategoryDiscount() {
        return this.categoryRepository.getCategoryDiscount();
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.getAllCategoryList();
    }
}
