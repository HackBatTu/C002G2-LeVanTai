package com.link.service;

import com.link.model.Blogger;
import com.link.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blogger> getAllBlog(String searchName , Pageable pageable) {
        return this.blogRepository.getAllBlog("%" + searchName + "%" ,pageable);
    }

    @Override
    public void deleteBlog(int id) {
        this.blogRepository.deleteBlog(id);
    }

    @Override
    public void save(Blogger blogger) {
        this.blogRepository.save(blogger);
    }


    @Override
    public Blogger getBlogger(int id) {
        return this.blogRepository.getBlogger(id);
    }


}
