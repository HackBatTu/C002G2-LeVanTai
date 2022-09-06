package com.shoponlineapi.controller;

import com.shoponlineapi.dto.IProductDTO;
import com.shoponlineapi.dto.ProductDTO;
import com.shoponlineapi.model.Category;
import com.shoponlineapi.model.Product;
import com.shoponlineapi.service.ICategoryService;
import com.shoponlineapi.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/product")
    public ResponseEntity<Page<IProductDTO>> getPageProduct(@PageableDefault(20)Pageable pageable,
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
    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        Product product = iProductService.findById(id);
        if(product.getId() == null){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping("/product/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        iProductService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/product/edit")
    public ResponseEntity<?> editProduct(@Valid @RequestBody ProductDTO productDTO , BindingResult bindingResult){
        Product product  = iProductService.findById(productDTO.getId());
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        BeanUtils.copyProperties(productDTO,product);
        iProductService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
        this.iProductService.deleteProduct(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categoryList = iCategoryService.getAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


}
