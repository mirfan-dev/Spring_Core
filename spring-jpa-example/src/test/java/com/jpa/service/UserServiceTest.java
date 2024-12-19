package com.jpa.service;

import com.jpa.dto.UserType;
import com.jpa.entity.Address;
import com.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUserTest(){

        User user = new User();
        user.setUserId(101);
        user.setName("Md Irfan");
        user.setEmail("mirfan@gmail.com");
        user.setType(UserType.STUDENT);
        user.setAge(33);
        user.setActive(true);
        Address address = new Address();
        address.setStreet("Batla house");
        address.setCountry("INDIA");
        address.setPinCode("110025");
        user.setAddress(address);
        User save = userService.save(user);
        System.out.println(save.getName());
    }

}
