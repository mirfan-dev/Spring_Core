package com.jpa.repository;

import com.jpa.dto.UserType;
import com.jpa.entity.Laptop;
import com.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToOneMapping {

    @Autowired
    private UserRepository repository;

    @Autowired
    private LaptopRepository laptopRepository;

    @Test
    public void oneToOneSaveUserTest() {

        User user = new User();

        user.setUserId(1010);
        user.setEmail("mirfan@gmail.com");
        user.setName("Md Irfan");
        user.setAge(22);
        user.setType(UserType.STUDENT);
        user.setActive(true);

        Laptop laptop = new Laptop();


        laptop.setAbout("Dell Inspiration 1234");
        laptop.setModel("This is latest dell model");
        laptop.setUser(user);

        user.setLaptop(laptop);
        repository.save(user);
    }

    @Test
    public void fetchUserAndLaptopByUser(){
        User user1=repository.findById(1010).orElseThrow(()->new RuntimeException("User not found"));
        System.out.println(user1.getName());
        Laptop laptop=user1.getLaptop();
        System.out.println(laptop.getModel());
        }

        @Test
    public void fetchUserAndLaptopByLaptop() {
            Laptop laptop = laptopRepository.findById(1).orElseThrow(() -> new RuntimeException("Laptop id not found"));
            System.out.println(laptop.getModel());
            User user = laptop.getUser();
            System.out.println(user.getName());
        }



}
