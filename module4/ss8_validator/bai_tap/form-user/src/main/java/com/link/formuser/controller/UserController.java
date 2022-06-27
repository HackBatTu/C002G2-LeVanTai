package com.link.formuser.controller;

import com.link.formuser.dto.UserDTO;
import com.link.formuser.model.User;
import com.link.formuser.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("userDTO", new UserDTO());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public String checkValidation(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            this.iUserService.save(user);
            redirectAttributes.addFlashAttribute("success","Register success!");
            return "redirect:/user/";
        }
    }
}
