package com.core.custombeanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("dao")
public class UserDao {


    public UserDao() {
        System.out.println("Initiating user dao");
    }

    String connection=null;
    Scanner sc=null;

    public void saveUser(){
        System.out.println("===========");
        System.out.println("using db connection");
        System.out.println(connection.length());
        System.out.println("saving user");
        System.out.println("==========");
    }

    public void printAllUser(){
        System.out.println("=============");
        System.out.println("using db connection");
        System.out.println(connection.length());
        System.out.println(".......done........");
    }
    @PostConstruct
    public void init(){
        sc=new Scanner(System.in);
        System.out.println("Enter connection");
        connection=sc.nextLine();

    }
    @PreDestroy
    public void destroy(){
        connection=null;
        sc.close();
        System.out.println("destroying connection");
    }
}
