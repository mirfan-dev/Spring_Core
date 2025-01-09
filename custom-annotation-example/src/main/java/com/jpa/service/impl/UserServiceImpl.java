package com.jpa.service.impl;

import com.jpa.dto.User;
import com.jpa.repository.UserRepository;
import com.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }
}
