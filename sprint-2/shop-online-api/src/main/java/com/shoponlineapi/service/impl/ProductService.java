package com.shoponlineapi.service.impl;

import com.shoponlineapi.dto.IProductDTO;
import com.shoponlineapi.repository.IProductRepository;
import com.shoponlineapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<IProductDTO> getAllProduct(Pageable pageable, String searchByName, String searchByOrigin, String searchByPrice) {
        return iProductRepository.getAllProduct(pageable, "%"+ searchByName + "%", "%"+ searchByOrigin + "%","%"+ searchByPrice + "%");
    }
}
