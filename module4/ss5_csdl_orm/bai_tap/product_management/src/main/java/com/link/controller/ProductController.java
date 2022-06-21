package com.link.controller;

import com.link.model.Product;
import com.link.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private  IProductService productService;

    @GetMapping("")
    public String index(Model model){
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/product/";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product){
        productService.edit(product);
        return "redirect:/product/";
    }
    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product){
        productService.delete(product.getId());
        return "redirect:/product/";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "details";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam String search, Model model){
        List<Product> products = productService.getProductByName(search);
        model.addAttribute("products", products);
        return "index";
    }
}