package com.link.musicvalidate.controller;

import com.link.musicvalidate.dto.MusicDTO;
import com.link.musicvalidate.model.Music;
import com.link.musicvalidate.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/musics")
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String listMusic(Model model){
        model.addAttribute("music", iMusicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createMusic(Model model){
        model.addAttribute("music", new Music());
        model.addAttribute("category",iMusicService.getAllCategory());
        return "create";
    }
    @PostMapping("/create")
    public String saveMusic(@ModelAttribute @Valid MusicDTO musicDTO, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,Model model){
        new MusicDTO().validate(musicDTO,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("category",iMusicService.getAllCategory());
            return "create";
        }
        Music music = new Music();
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("msg","register successfully");
        return "redirect:/musics";
    }
    @GetMapping("/edit/{id}")
    public String editMusic(Model model, @PathVariable int id){
        model.addAttribute("music", iMusicService.findById(id));
        model.addAttribute("category",iMusicService.getAllCategory());
        return "edit";
    }
    @PostMapping("/edit")
    public String editsMusic(Music music){
        iMusicService.save(music);
        return "redirect:/musics";
    }
}
