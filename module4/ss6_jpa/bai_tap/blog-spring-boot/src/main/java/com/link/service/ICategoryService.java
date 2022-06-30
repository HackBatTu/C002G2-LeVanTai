package com.link.service;

import com.link.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();

    Category save(Category category);

    Category findById(int id);

    void delete(int id);
}
