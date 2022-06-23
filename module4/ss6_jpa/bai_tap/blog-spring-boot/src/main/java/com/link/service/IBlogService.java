package com.link.service;

import com.link.model.Blogger;

import java.util.List;

public interface IBlogService {

    List<Blogger> getAllBlog();

    void deleteBlog(int id);

    void save(Blogger blogger);

    Blogger getBlogger(int id);
}
