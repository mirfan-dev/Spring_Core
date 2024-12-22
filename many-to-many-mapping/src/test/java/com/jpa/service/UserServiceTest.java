package com.jpa.service;


import com.jpa.entity.Role;
import com.jpa.entity.RoleEntity;
import com.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test

    public void saveUserAndRoleEntityTest(){
        User user=new User();
        user.setEmail("mirfan@gmail.com");
        user.setName("MD Irfan");
        user.setAddress("Bihar");
        user.setPassowrd("123Irfan");


        User user1=new User();
        user1.setEmail("arman@gmail.com");
        user1.setName("Arman Ali");
        user1.setAddress("Bihar");
        user1.setPassowrd("123Arman");



        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setRole(Role.ADMIN);
        roleEntity.getUsers().add(user);
        roleEntity.getUsers().add(user1);



        user.getRoleEntities().add(roleEntity);
        user1.getRoleEntities().add(roleEntity);

        service.saveUser(user);
        service.saveUser(user1);
        System.out.println("data saved");




    }
}
