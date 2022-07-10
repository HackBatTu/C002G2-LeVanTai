package com.link.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception ex){
        System.out.println(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("errors");
        return modelAndView;
    }
}
