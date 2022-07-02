package com.link.controller;

import com.link.model.Blogger;
import com.link.model.Category;
import com.link.service.IBlogService;
import com.link.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class RestBlogController {
    @Autowired
    ICategoryService iCategoryService;

    @Autowired
    IBlogService iBlogService;

    @GetMapping("/blog")
    public ResponseEntity<Page<Blogger>> getListBlog(@PageableDefault(value = 5) Pageable pageable,@RequestParam Optional<String> search){
        String searchName = search.orElse("");
        Page<Blogger> bloggerPage = iBlogService.getAllBlog(searchName,pageable);
        if(!bloggerPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bloggerPage,HttpStatus.OK);

    }
//    @PostMapping("/create")
//    public ResponseEntity<List<FieldError>> create(@Validated @RequestBody Blogger blogger, BindingResult bindingResult){
//        if(bindingResult.hasFieldErrors()){
//            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
//        }
//        iBlogService.save(blogger);
//        return new ResponseEntity<>(HttpStatus.OK);
//
//    }
    @PostMapping("/blog/create")
    public ResponseEntity<Blogger> createBlogger(@RequestBody Blogger blogger) {
    return new ResponseEntity<>(iBlogService.save(blogger), HttpStatus.CREATED);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blogger> findByIdBlog(@PathVariable int id) {
    Optional<Blogger> optionalBlogger = Optional.ofNullable(iBlogService.getBlogger(id));
    if (!optionalBlogger.isPresent()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(optionalBlogger.get(), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categoryList = iCategoryService.getAllCategory();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( categoryList,HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> findByIdCategory(@PathVariable int id) {
        Optional<Category> optionalCategory = Optional.ofNullable(iCategoryService.findById(id));
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalCategory.get(), HttpStatus.OK);
    }

    @PostMapping("/category/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(iCategoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        Optional<Category> categoryOptional = Optional.ofNullable(iCategoryService.findById(id));
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(categoryOptional.get().getId());
        return new ResponseEntity<>(iCategoryService.save(category), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable int id){
        Optional<Category> categoryOptional = Optional.ofNullable(iCategoryService.findById(id));
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCategoryService.delete(id);
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.NO_CONTENT);
    }
}
