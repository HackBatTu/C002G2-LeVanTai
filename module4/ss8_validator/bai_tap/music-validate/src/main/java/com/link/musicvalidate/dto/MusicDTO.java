package com.link.musicvalidate.dto;

import com.link.musicvalidate.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class MusicDTO {
    private int id;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 800,message = "cant high 800 char")
    @Pattern(regexp = "[A-Za-z0-9\\s]+", message = "no valid")
    private String name;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 300,message = "cant high 300 char")
    @Pattern(regexp = "[A-Za-z0-9\\s]+", message = "no valid")
    private String singer;
    @NotNull
    private Category category;

    public MusicDTO() {
    }

    public MusicDTO(int id,String name, String singer, Category category) {
        this.id = id;
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
}
