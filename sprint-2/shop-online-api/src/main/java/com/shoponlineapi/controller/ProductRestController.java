package com.shoponlineapi.controller;

import com.shoponlineapi.dto.IProductDTO;
import com.shoponlineapi.model.Category;
import com.shoponlineapi.model.Product;
import com.shoponlineapi.service.ICategoryService;
import com.shoponlineapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class ProductRestController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/product/page")
    public ResponseEntity<Page<IProductDTO>> getPageProduct(@PageableDefault(10)Pageable pageable,
                                                            Optional<String> searchPrice,
                                                            Optional<String> searchOrigin,
                                                            Optional<String> searchName){
       String searchByName = searchName.orElse("");
       String searchByPrice = searchPrice.orElse("");
       String searchByOrigin = searchOrigin.orElse("");

        Page<IProductDTO> productDTOPage = iProductService.getAllProduct(pageable,searchByName,searchByOrigin,searchByPrice);
        if(productDTOPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDTOPage,HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList = iCategoryService.getAllCategory();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }


}
