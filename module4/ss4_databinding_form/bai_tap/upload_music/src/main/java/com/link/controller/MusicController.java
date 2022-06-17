package com.link.controller;

import com.link.model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {

    @GetMapping("/")
    public String show(Model model){
        model.addAttribute("music",new Music());
        return "index";
    }

    @PostMapping("/long")
    public String music(@ModelAttribute Music music,Model model){
        model.addAttribute("musicResult",music);
        return "index";
    }
}
