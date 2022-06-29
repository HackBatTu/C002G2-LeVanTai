package com.link.booklibrary.service;

import com.link.booklibrary.model.Book;
import com.link.booklibrary.model.Library;

import java.util.List;

public interface ILibraryService {

    List<Library> findAll();

    void save(Library library);

    void borrowBook(Integer id);

    void setQuantity(Integer id);

}
