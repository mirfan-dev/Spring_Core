package com.jpa.service.impl;

import com.jpa.dto.UserDto;
import com.jpa.entity.User;
import com.jpa.exception.ResourceNotFoundException;
import com.jpa.mapper.UserMapper;
import com.jpa.repository.UserRepository;
import com.jpa.service.UserService;
import com.jpa.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDto saveUser(UserDto userDto) {

        userDto.setId(Helper.generateRandomUserId());
        User user= UserMapper.mapUserDtoToUser(userDto);
         User saveUser= repository.save(user);
        return UserMapper.mapUserToUserDto(saveUser);


    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user1=repository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("EmployeeDto not found with id "+userId));

        user1.setName(userDto.getName());
        user1.setRole(userDto.getRole());
        user1.setAddress(userDto.getAddress());
        user1.setEmail(userDto.getEmail());
        user1.setPassword(userDto.getPassword());
        user1.setPhoneNumber(userDto.getPhoneNumber());

        User updatedUserObject=repository.save(user1);

        return UserMapper.mapUserToUserDto(updatedUserObject);
    }

    @Override
    public UserDto getUserById(String id) {
        User user=repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User not found with id "+id));
        return UserMapper.mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users=repository.findAll();
        return users.stream().map((user) -> UserMapper.mapUserToUserDto(user))
                .toList();

    }

    @Override
    public void deleteByUserId(String id) {

        User user=repository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("User not found with id "+id));

        repository.delete(user);

    }

    @Override
    public Page<UserDto> getUserWithPagination(Pageable pageable) {
        Page<User> userPage=repository.findAll(pageable);

        return userPage.map((user) ->UserMapper.mapUserToUserDto(user));
    }

    @Override
    public List<UserDto> searchListOfUser(String keyword) {

        List<User> users=  repository.searchUser(keyword);

        return users.stream().map((user) -> UserMapper.mapUserToUserDto(user))
                .toList();
    }
}
