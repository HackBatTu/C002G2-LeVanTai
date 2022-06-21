package com.link.controller;

import com.link.model.Song;
import com.link.service.SongService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/songs")
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
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("song", new Song());
        modelAndView.addObject("message","new Song created success");
        return modelAndView;
    }
    @GetMapping("/edit-song/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Song song = songService.findById(id);
        if(song != null){
            ModelAndView modelAndView = new ModelAndView("/update");
            modelAndView.addObject("song",song);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-song")
    public  ModelAndView editSong(@ModelAttribute Song song){
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("song", new Song());
        modelAndView.addObject("message","new Song update success");
        return modelAndView;
    }
    @GetMapping("delete-song/{id}")
    public String showDelete(@PathVariable Integer id){
        songService.remove(id);
        return "redirect:/songs";
    }
}
