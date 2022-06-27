package com.link.formuser.service;

import com.link.formuser.model.User;
import com.link.formuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User save(User user) {
        return iUserRepository.save(user);
    }
}
