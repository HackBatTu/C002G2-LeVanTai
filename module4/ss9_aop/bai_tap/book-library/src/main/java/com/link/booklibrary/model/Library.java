package com.link.booklibrary.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id")
    private Integer id;
    private String name;
    private String day;
    private Integer quantity;

    @OneToMany(mappedBy = "library")
    private List<Book> bookList;

    public Library() {
    }

    public Library(Integer id, String name, String day, Integer quantity, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.quantity = quantity;
        this.bookList = bookList;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
