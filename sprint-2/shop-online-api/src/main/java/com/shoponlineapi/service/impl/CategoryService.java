package com.shoponlineapi.service.impl;

import com.shoponlineapi.repository.ICategoryRepository;
import com.shoponlineapi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
}
