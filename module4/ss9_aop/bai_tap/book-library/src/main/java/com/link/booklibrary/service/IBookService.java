package com.link.booklibrary.service;

import com.link.booklibrary.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    void setStatus(Integer id);

    void returnBook(Integer bookCode) throws Exception;
}
