package com.link.musicvalidate.controller;

import com.link.musicvalidate.dto.MusicDTO;
import com.link.musicvalidate.model.Music;
import com.link.musicvalidate.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("musicDTO", new MusicDTO());
        model.addAttribute("category",iMusicService.getAllCategory());
        return "create";
    }
    @PostMapping("/create")
    public String saveMusic(@Valid @ModelAttribute("musicDTO") MusicDTO musicDTO, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("category",iMusicService.getAllCategory());
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO,music);
        iMusicService.save(music);
        return "redirect:/musics";
    }
    @GetMapping("/edit/{id}")
    public String editMusic(Model model, @PathVariable int id){
        Music music = iMusicService.findById(id);
        MusicDTO musicDTO = new MusicDTO();
        BeanUtils.copyProperties(music,musicDTO);
        model.addAttribute("musicDTO",musicDTO);
        model.addAttribute("category",iMusicService.getAllCategory());
        return "edit";
    }
    @PostMapping("/edit")
    public String editsMusic(@Valid @ModelAttribute("musicDTO") MusicDTO musicDTO,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("category",iMusicService.getAllCategory());
            return "edit";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO,music);
        iMusicService.save(music);
        return "redirect:/musics";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        iMusicService.delete(id);
        return "redirect:/musics";
    }
}
