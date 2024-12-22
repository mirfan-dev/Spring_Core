package com.jpa.service.imp;

import com.jpa.dao.UserRepository;
import com.jpa.entity.User;
import com.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;



@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {

        String randomUserId=UUID.randomUUID().toString();
        user.setId(randomUserId);
        return userRepository.save(user);
    }
}
