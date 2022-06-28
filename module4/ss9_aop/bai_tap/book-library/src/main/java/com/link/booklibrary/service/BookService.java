package com.link.booklibrary.service;

import com.link.booklibrary.model.Book;
import com.link.booklibrary.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;


    @Override
    public List<Book> findAllBook() {
        return iBookRepository.findAllBook();
    }

    @Override
    public List<Book> findAllBorrow() {
        return iBookRepository.findAllBorrow();
    }

    @Override
    public void borrowBook(int idBook) {
        iBookRepository.borrowBook(idBook);
    }

    @Override
    public void returnBook(int idBook) {
        iBookRepository.returnBook(idBook);
    }


}
