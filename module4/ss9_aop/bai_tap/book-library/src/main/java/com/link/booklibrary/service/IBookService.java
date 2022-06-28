package com.link.booklibrary.service;

import com.link.booklibrary.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAllBook();

    List<Book> findAllBorrow();

    void borrowBook(int bookId);

    void returnBook(int bookId);
}
