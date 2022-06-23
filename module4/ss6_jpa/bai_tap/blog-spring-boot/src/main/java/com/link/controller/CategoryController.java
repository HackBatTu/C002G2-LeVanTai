package com.link.controller;

import com.link.model.Category;
import com.link.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public String listCategory(Model model){
        model.addAttribute("categoryList",iCategoryService.getAllCategory());
        return "/category/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("category",new Category());
        return "/category/create";
    }
    @PostMapping("/create")
    public String createCate(@ModelAttribute Category category){
        iCategoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "/category/edit";
    }
    @PostMapping("/edit")
    public String editCate(@ModelAttribute Category category){
        iCategoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
       iCategoryService.delete(id);
       return "redirect:/category";
    }
}
