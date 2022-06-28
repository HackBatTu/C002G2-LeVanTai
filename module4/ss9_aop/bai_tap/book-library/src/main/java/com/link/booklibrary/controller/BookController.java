package com.link.booklibrary.controller;

import com.link.booklibrary.model.Library;
import com.link.booklibrary.service.IBookService;
import com.link.booklibrary.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private ILibraryService iLibraryService;

    @GetMapping("/listBook")
    public String listBook(Model model){
        model.addAttribute("book",iBookService.findAllBook());
        return "book";
    }
    @GetMapping("/listBookBorrow")
    public String listBorrow(Model model){
        model.addAttribute("book",iBookService.findAllBorrow());
        return "list-borrow";
    }

    @GetMapping("/borrow/{bookId}")
    public String borrowBooks(@PathVariable int id,@PathVariable int bookId, RedirectAttributes redirectAttributes) {
        Library library = iLibraryService.findById(id);
        iBookService.borrowBook(bookId);
        library.setQuantity(library.getQuantity() - 1);
        redirectAttributes.addFlashAttribute("mess", "đã mươn sách thành công, mã mượn sách của bạn là : " + id);
        return "redirect:/library";
    }


    @GetMapping("/return/{bookId}")
    public String returnBooks(@RequestParam int id,@PathVariable int bookId) {
        Library library = iLibraryService.findById(id);
        iBookService.returnBook(bookId);
        library.setQuantity(library.getQuantity() + 1);
        return "redirect:/library";
    }


}
