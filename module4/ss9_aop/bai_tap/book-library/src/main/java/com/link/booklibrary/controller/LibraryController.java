package com.link.booklibrary.controller;

import com.link.booklibrary.model.Book;
import com.link.booklibrary.model.Library;
import com.link.booklibrary.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private ILibraryService iLibraryService;

    @GetMapping("")
    public String library(Model model){
        model.addAttribute("library",iLibraryService.findAll());
        return "library";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("library",new Library());
        return "/create-book";
    }
    @PostMapping("/create")
    public String saveBook(@ModelAttribute Library library){
        iLibraryService.save(library);
        return "redirect:/library";
    }
}