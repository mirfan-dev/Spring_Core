package com.jpa.service;

import com.jpa.entity.Restaurant;
import com.jpa.entity.Role;
import com.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;


    @Test
    public void testSaveUser(){

        //user

        User user = new User();
        user.setName("Md Irfan");
        user.setEmail("mirfan@gmail.com");
        user.setAvailable(true);
        user.setAddress("Test address, DELHI");
        user.setPassword("abc");
        user.setRole(Role.ADMIN);

        // restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.randomUUID().toString());
        restaurant.setName("KFC");
        restaurant.setAddress("Delhi");
        restaurant.setOpen(true);
        restaurant.setUser(user);

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setId(UUID.randomUUID().toString());
        restaurant1.setName("Haldiram");
        restaurant1.setAddress("Noida");
        restaurant1.setOpen(true);
        restaurant1.setUser(user);

        user.getRestaurants().add(restaurant);
        user.getRestaurants().add(restaurant1);

        User saved = service.saveUser(user);
        System.out.println(saved.getName());


    }
}
