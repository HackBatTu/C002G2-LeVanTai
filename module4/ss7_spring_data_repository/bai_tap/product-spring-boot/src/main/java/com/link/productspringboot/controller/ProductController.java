package com.link.productspringboot.controller;

import com.link.productspringboot.model.Product;
import com.link.productspringboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String listProduct(Model model){
        model.addAttribute("product", iProductService.getAllProduct());
        return "/list";
    }

    @GetMapping("/create")
    public ModelAndView createProduct(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createProducts(Product product){
        iProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product",iProductService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editProducts(Product product){
        iProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id){
        iProductService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }
    @GetMapping("/details/{id}")
    public ModelAndView detailsProduct(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/details");
        modelAndView.addObject("product",iProductService.findById(id));
        return modelAndView;
    }

}
