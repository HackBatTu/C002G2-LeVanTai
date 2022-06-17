package com.link.model;

public class Music {
    private String name;
    private String author;
    private String category;
    private String link;

    public Music(String name, String author, String category, String link) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.link = link;
    }

    public Music() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
