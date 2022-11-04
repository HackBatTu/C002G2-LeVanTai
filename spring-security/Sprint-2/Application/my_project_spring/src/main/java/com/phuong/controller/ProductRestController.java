package com.phuong.controller;

import com.phuong.dto.ErrorDto;
import com.phuong.dto.ProductDto;
import com.phuong.model.Product;
import com.phuong.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/new/products")
    public ResponseEntity<List<Product>> getNewProducts() {
        List<Product> productList = this.productService.getNewProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
    public ResponseEntity<?> createNewProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        this.productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/product/edit", method = RequestMethod.POST)
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        this.productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/product/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Product>> getAllPageProducts(
            @RequestParam(value = "categoryId", required = false, defaultValue = "") String categoryId,
            @RequestParam(value = "productName", required = false, defaultValue = "") String productName,
            @RequestParam(value = "beginPrice", required = false, defaultValue = "0") String beginPrice,
            @RequestParam(value = "endPrice", required = false, defaultValue = "400000000000") String endPrice,
            @RequestParam(value = "originName", required = false, defaultValue = "") String originName,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "9") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "id") String sort) {
        Sort sortable = getSorts(sort);
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Product> productPage = this.productService.findAll(pageable, categoryId, productName, beginPrice, endPrice, originName);
        if (productPage.hasContent()) {
            return new ResponseEntity<>(productPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Sort getSorts(String sort) {
        Sort sortable;
        switch (sort) {
            case "manufacture_time":
                sortable = Sort.by(Sort.Order.desc(sort));
                break;
            case "price,desc":
                sortable = Sort.by(Sort.Order.desc("price"));
                break;
            case "price,asc":
                sortable = Sort.by(Sort.Order.asc("price"));
                break;
            default:
                sortable = Sort.by(Sort.Order.asc(sort));
                break;
        }
        return sortable;
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllListProducts() {
        List<Product> productList = this.productService.findAll();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = this.productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        Boolean check = this.productService.deleteProduct(id);
        if (check) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("idnotfound");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
