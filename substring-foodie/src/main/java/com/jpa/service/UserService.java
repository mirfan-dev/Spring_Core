package com.jpa.service;

import com.jpa.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto user);


    public UserDto updateUser(UserDto user, String userId);


    public UserDto getUserById(String id);

    public List<UserDto> getAllUser();


    public void deleteByUserId(String id);

    public Page<UserDto> getUserWithPagination(Pageable pageable);

    public List<UserDto> searchListOfUser(String keyword);
}
