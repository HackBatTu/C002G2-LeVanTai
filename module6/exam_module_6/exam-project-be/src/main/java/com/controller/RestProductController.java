package com.controller;

import com.dto.ProductDTO;
import com.model.Product;
import com.model.ProductType;
import com.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class RestProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/product")
    public ResponseEntity<Page<Product>> getAllProduct(@PageableDefault(3) Pageable pageable) {

        Page<Product> productPage = iProductService.getAllProduct(pageable);
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<FieldError> createProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        ProductDTO productDTO1 =new ProductDTO();
        productDTO1.setProductList(this.iProductService.finAll());
        productDTO1.validate(productDTO,bindingResult);
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        iProductService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/productType")
    public ResponseEntity<List<ProductType>> getAllProductType() {
        List<ProductType> productTypeList = iProductService.getAllProductType();
        return new ResponseEntity<>(productTypeList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        this.iProductService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
