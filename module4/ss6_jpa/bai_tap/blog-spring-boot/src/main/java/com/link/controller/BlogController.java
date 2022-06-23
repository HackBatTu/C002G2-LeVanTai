package com.link.controller;

import com.link.model.Blogger;
import com.link.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/bloggers")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public String displayBlog(Model model){
        model.addAttribute("blogList", this.iBlogService.getAllBlog());
        return "list";
    }
    @GetMapping("/create")
    public String createBlog(Model model){
        model.addAttribute("blog", new Blogger());
        return "create";
    }
    @PostMapping("/create")
    public String saveBlog(Blogger blogger){
        this.iBlogService.save(blogger);
        return "redirect:/bloggers";
    }
    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable Integer id , Model model){
        model.addAttribute("blog",iBlogService.getBlogger(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String updateBlog(Blogger blogger){
        this.iBlogService.save(blogger);
        return "redirect:/bloggers";
    }
    @GetMapping("/delete")
    public String deleteBlog(@PathVariable Integer id){
        this.iBlogService.deleteBlog(id);
        return "redirect:/bloggers";
    }
    @GetMapping("/details/{id}")
    public String showDetail(@PathVariable int id, Model model){
        model.addAttribute("blog",this.iBlogService.getBlogger(id) );
        return "details";
    }
}
