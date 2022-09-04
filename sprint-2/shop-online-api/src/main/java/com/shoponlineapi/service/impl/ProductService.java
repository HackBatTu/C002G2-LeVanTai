package com.shoponlineapi.service.impl;

import com.shoponlineapi.repository.IProductRepository;
import com.shoponlineapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;
}
