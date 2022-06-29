package com.link.controller;

import com.link.model.Product;
import com.link.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
@SessionAttributes(value = "listProductSession")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String goList(Model model){
        model.addAttribute("products", iProductService.findAll());
        model.addAttribute("product",new Product());
        return "home";
    }
    @ModelAttribute(value = "listProductSession")
    public List<Product> listProductSession(){
        return new ArrayList<>();
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Product product){
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/add-cart")
    public String addToCart(@SessionAttribute("listProductSession") List<Product> listProductSession, RedirectAttributes redirectAttributes, @RequestParam("id") int id){
        Product product = iProductService.getById(id);
        listProductSession.add(product);
        redirectAttributes.addFlashAttribute("msg", "Add product " + product.getName() + " success!");
        return "redirect:/product";
    };
    @GetMapping("/show-cart")
    public String showCart(@SessionAttribute("listProductSession") List<Product> listProductSession, Model model) {
        model.addAttribute("products", listProductSession);
        return "cart-list";
    }

    @GetMapping("/buy")
    public String buyProduct(@SessionAttribute("listProductSession") List<Product> listProductSession){
        listProductSession.clear();
        return "redirect:/product/show-cart";
    }

}
