package com.link.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Blogger> bloggers;

    public Category() {
    }

    public Category(int id, String name, List<Blogger> bloggers) {
        this.id = id;
        this.name = name;
        this.bloggers = bloggers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blogger> getBloggers() {
        return bloggers;
    }

    public void setBloggers(List<Blogger> bloggers) {
        this.bloggers = bloggers;
    }
}
