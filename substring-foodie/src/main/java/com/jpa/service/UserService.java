package com.jpa.service;

import com.jpa.entity.User;

public interface UserService {

    User saveUser(User user);
    public User updateUser(User user, String userId);
}
