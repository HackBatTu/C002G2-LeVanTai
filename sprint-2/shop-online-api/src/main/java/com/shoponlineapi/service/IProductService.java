package com.shoponlineapi.service;

import com.shoponlineapi.dto.IProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<IProductDTO> getAllProduct(Pageable pageable, String searchByName, String searchByOrigin, String searchByPrice);
}
