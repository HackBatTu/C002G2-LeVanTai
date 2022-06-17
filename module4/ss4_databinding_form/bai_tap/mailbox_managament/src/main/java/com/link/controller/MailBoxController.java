package com.link.controller;

import com.link.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxController {

    @GetMapping("/")
    public String showMailbox(Model model) {
        model.addAttribute("mailBox", new MailBox());
        return "index";
    }

    @PostMapping("/mailbox")
    public String Mailbox(@ModelAttribute MailBox mailBox, Model model) {
        model.addAttribute("mailBoxResult", mailBox);
        return "index";
    }

}
