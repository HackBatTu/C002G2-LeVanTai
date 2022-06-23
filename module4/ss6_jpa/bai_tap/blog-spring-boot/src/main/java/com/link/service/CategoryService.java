package com.link.service;

import com.link.model.Category;
import com.link.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.getAllCategory();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        iCategoryRepository.delete(findById(id));
    }
}
