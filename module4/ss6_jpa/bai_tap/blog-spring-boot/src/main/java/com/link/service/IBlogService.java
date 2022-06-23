package com.link.service;

import com.link.model.Blogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

//    List<Blogger> getAllBlog();
    Page<Blogger> getAllBlog(String searchName, Pageable pageable);

    void deleteBlog(int id);

    void save(Blogger blogger);

    Blogger getBlogger(int id);
}
