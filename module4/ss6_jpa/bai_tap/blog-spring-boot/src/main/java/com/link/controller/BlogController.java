package com.link.controller;

import com.link.model.Blogger;
import com.link.service.IBlogService;
import com.link.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/bloggers")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String displayBlog(Model model, @PageableDefault(value = 5)Pageable pageable, @RequestParam Optional<String> search){
        String searchName = search.orElse("");
        model.addAttribute("searchName",searchName);
        model.addAttribute("blogList", this.iBlogService.getAllBlog(searchName,pageable));
        return "list";
    }
    @GetMapping("/create")
    public String createBlog(Model model){
        model.addAttribute("blog", new Blogger());
        model.addAttribute("categories", this.categoryService.getAllCategory());
        return "create";
    }
    @PostMapping("/create")
    public String saveBlog(Blogger blogger){
        this.iBlogService.save(blogger);
        return "redirect:/bloggers/list";
    }
    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable Integer id , Model model){
        model.addAttribute("blog",iBlogService.getBlogger(id));
        model.addAttribute("categories", this.categoryService.getAllCategory());
        return "edit";
    }
    @PostMapping("/edit")
    public String updateBlog(Blogger blogger){
        this.iBlogService.save(blogger);
        return "redirect:/bloggers";
    }
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id){
        this.iBlogService.deleteBlog(id);
        return "redirect:/bloggers/list";
    }
    @GetMapping("/details/{id}")
    public String showDetail(@PathVariable int id, Model model){
        model.addAttribute("blog",this.iBlogService.getBlogger(id) );
        return "details";
    }
}
