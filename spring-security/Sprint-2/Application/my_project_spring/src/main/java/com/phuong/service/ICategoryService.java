package com.phuong.service;

import com.phuong.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    List<Category> getCategoryDiscount();

    List<Category> findAll();
}
