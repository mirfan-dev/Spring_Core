package com.jpa.repository;

import com.jpa.dto.UserType;
import com.jpa.entity.Laptop;
import com.jpa.entity.User;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class OneToManyTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private LaptopRepository laptopRepository;


    @Test
    public void oneToManySaveTest(){

        User user=new User();
        user.setUserId(1010);
        user.setType(UserType.FACULTY);
        user.setName("Durgesh Sir");
        user.setAge(45);
        user.setEmail("durgesh@gmail.com");
        user.setActive(true);

        Laptop laptop=new Laptop();
        laptop.setModel("Aspire S3-391-53314G52");
        laptop.setAbout("This is latest acer model");
        laptop.setUser(user);

        Laptop laptop1=new Laptop();
        laptop1.setModel("iPhone 16 Pro");
        laptop1.setAbout("the most recent iPhone models are the iPhone 16");
        laptop1.setUser(user);

        user.getLaptop().add(laptop);
        user.getLaptop().add(laptop1);

        repository.save(user);
    }

    @Test
    @Transactional
    public void getUserAndLaptopByUser(){
        User user=repository.findById(1010).orElseThrow(()->new RuntimeException("User id not found"));
        System.out.println(user.getName());
        List<Laptop> laptops=user.getLaptop();
        laptops.forEach(laptop -> {
            System.out.println(laptop.getModel());
        });
    }

    @Test
    public void getUserAndLaptopByLaptop(){
        Laptop laptop=laptopRepository.findById(1).orElseThrow(()->new RuntimeException("Laptop not found"));
        System.out.println(laptop.getModel());
        User user=laptop.getUser();
        System.out.println(user.getName());
    }
}
