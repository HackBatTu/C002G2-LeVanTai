package com.link.musicvalidate.dto;

import com.link.musicvalidate.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDTO implements Validator {
    @NotBlank
    @Size(max = 800,message = "cant high 800 char")
    @Pattern(regexp = "[0-9A-Za-z]")
    private String name;
    @NotBlank
    @Size(max = 300,message = "cant high 300 char")
    @Pattern(regexp = "[0-9A-Za-z]")
    private String singer;
    @NotBlank
    @Size(max = 800,message = "cant high 1000 char")
    @Pattern(regexp = "[0-9A-Za-z,]")
    private Category category;

    public MusicDTO() {
    }

    public MusicDTO( @NotBlank
                     @Size(max = 800,message = "cant high 800 char")
                     @Pattern(regexp = "[0-9A-Za-z]") String name,
                     @NotBlank
                     @Size(max = 800,message = "cant high 800 char")
                     @Pattern(regexp = "[0-9A-Za-z]") String singer,
                     @NotBlank
                     @Size(max = 800,message = "cant high 1000 char")
                     @Pattern(regexp = "[0-9A-Za-z,]") Category category) {
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDTO musicDTO = (MusicDTO) target;
    }
}
