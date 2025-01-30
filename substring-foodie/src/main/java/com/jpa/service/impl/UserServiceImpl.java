package com.jpa.service.impl;

import com.jpa.dto.UserDto;
import com.jpa.entity.RoleEntity;
import com.jpa.entity.User;
import com.jpa.exception.ResourceNotFoundException;
import com.jpa.repository.RoleEntityRepository;
import com.jpa.repository.UserRepository;
import com.jpa.service.UserService;
import com.jpa.utils.AppConstant;
import com.jpa.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    private PasswordEncoder passwordEncoder;

    private RoleEntityRepository roleEntityRepository;

    private ModelMapper mapper;


    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, RoleEntityRepository roleEntityRepository, ModelMapper mapper) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.roleEntityRepository = roleEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {

        userDto.setId(Helper.generateRandomUserId());
        User user= mapper.map(userDto,User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity role=roleEntityRepository.findByName(AppConstant.getGuestRole());
        user.getRoleEntities().add(role);
         User saveUser= repository.save(user);
        return mapper.map(saveUser,UserDto.class);


    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user1=repository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("EmployeeDto not found with id "+userId));

        user1.setName(userDto.getName());
        user1.setAddress(userDto.getAddress());
        user1.setEmail(userDto.getEmail());
        user1.setPassword(userDto.getPassword());
        user1.setPhoneNumber(userDto.getPhoneNumber());

        User updatedUserObject=repository.save(user1);

        return mapper.map(updatedUserObject,UserDto.class);
    }

    @Override
    public UserDto getUserById(String id) {
        User user=repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User not found with id "+id));
        return mapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users=repository.findAll();
        return users.stream().map((user) -> mapper.map(user,UserDto.class))
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

        return userPage.map((user) ->mapper.map(user,UserDto.class));
    }

    @Override
    public List<UserDto> searchListOfUser(String keyword) {

        List<User> users=  repository.searchUser(keyword);

        return users.stream().map((user) -> mapper.map(user,UserDto.class))
                .toList();
    }
}
