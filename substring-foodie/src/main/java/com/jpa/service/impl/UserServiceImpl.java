package com.jpa.service.impl;

import com.jpa.dao.UserRepository;
import com.jpa.entity.User;
import com.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setId(randomUserId);
        return userRepository.save(user) ;
    }

    @Override
    public User updateUser(User user, String userId) {
        User user1 = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        user1.setName(user.getName());
//        ..all fields
        User save = userRepository.save(user1);
        return save;
    }

}
