package com.jpa.repository;

import com.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByEmailTest() {
        Optional<User> userOptional = userRepository.findByEmailOrderByNameAsc("mirfan@gmail.com");

        User user = userOptional.orElseThrow(() -> new RuntimeException("user not found"));
        System.out.println(user.getUserId());
        System.out.println(user.getName());
        System.out.println(user.getEmail());
    }
}
