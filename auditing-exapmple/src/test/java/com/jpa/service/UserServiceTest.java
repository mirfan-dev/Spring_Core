package com.jpa.service;

import com.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {


    @Autowired
    private UserService service;

    @Test
    public void saveTest(){
        User user=new User();
        user.setName("Arman Ali");
        user.setEmail("arman@gmail.com");
        user.setCity("Bihar");

        service.saveUser(user);


    }
}
