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
        user.setRole(Role.ADMIN);
        user.setAddress("Bihar");
        user.setPassowrd("123Irfan");




        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setName("Md Irfan");
        roleEntity.getUsers().add(user);

        RoleEntity roleEntity1=new RoleEntity();
        roleEntity1.setName("Arman Ali");
        roleEntity1.getUsers().add(user);

        user.getRoleEntities().add(roleEntity);
        user.getRoleEntities().add(roleEntity1);

        service.saveUser(user);




    }
}
