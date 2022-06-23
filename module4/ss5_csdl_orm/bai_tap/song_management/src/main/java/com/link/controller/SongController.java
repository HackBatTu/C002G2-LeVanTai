package com.link.controller;

import com.link.model.Song;
import com.link.service.SongService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/")
    public ModelAndView listSong(){
        List<Song> songs= songService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("songs",songs);
        return modelAndView;
    }
    @GetMapping("/create-song")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("song",new Song());
        return modelAndView;
    }
    @PostMapping("/create-song")
    public ModelAndView save(@ModelAttribute Song song){
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("redirect:/songs/");
        modelAndView.addObject("song", new Song());
        modelAndView.addObject("message","new Song created success");
        return modelAndView;
    }
    @GetMapping("/edit-song/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("song", songService.findById(id));
        return "update";
    }
    @PostMapping("/edit-song")
    public String edit( @ModelAttribute Song song){
        songService.update(song);
        return "redirect:/songs/";
    }
    @GetMapping("delete-song/{id}")
    public String showDelete(@ModelAttribute Song song){
        songService.remove(song.getId());
        return "redirect:/songs";
    }
}
