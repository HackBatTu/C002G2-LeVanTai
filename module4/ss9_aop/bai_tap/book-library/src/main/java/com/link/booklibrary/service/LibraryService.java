package com.link.booklibrary.service;

import com.link.booklibrary.model.Library;
import com.link.booklibrary.repository.ILibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class LibraryService implements ILibraryService{

    @Autowired
    private ILibraryRepository iBookLibraryRepository;

    @Override
    public List<Library> findAll() {
        return iBookLibraryRepository.findAll();
    }

     @Override
     public void save(Library library) {
         iBookLibraryRepository.save(library);
     }

     @Override
     public Library findById(Integer id) {
         return  iBookLibraryRepository.findById(id).orElse(null);
     }


 }
