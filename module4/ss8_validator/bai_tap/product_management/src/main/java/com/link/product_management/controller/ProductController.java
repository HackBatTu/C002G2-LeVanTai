package com.link.product_management.controller;

import com.link.product_management.dto.ProductDTO;
import com.link.product_management.model.Product;
import com.link.product_management.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
        modelAndView.addObject("productDTO", new Product());
        modelAndView.addObject("manufacturer",iProductService.getAllManufacturer());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createProducts(@Valid @ModelAttribute("productDTO") ProductDTO productDTO , BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/create");
        if(bindingResult.hasErrors()){
            modelAndView.addObject("manufacturer",iProductService.getAllManufacturer());
            return modelAndView;
        }
        Product product= new Product();
        BeanUtils.copyProperties(productDTO,product);
        iProductService.save(product);
        return new ModelAndView("redirect:/products");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editFormProduct(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("manufacturer",iProductService.getAllManufacturer());
        modelAndView.addObject("productDTO",iProductService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO , BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/edit");
        if(bindingResult.hasErrors()){
            modelAndView.addObject("manufacturer",iProductService.getAllManufacturer());
            return modelAndView;
        }
        Product product= new Product();
        BeanUtils.copyProperties(productDTO,product);
        iProductService.save(product);
        return new ModelAndView("redirect:/products");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id){
        iProductService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }

}
