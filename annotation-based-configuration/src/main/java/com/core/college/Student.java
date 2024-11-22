package com.core.college;

import org.springframework.stereotype.Component;

@Component
public class Student {

    public Student(){
        System.out.println("Creating student object");
    }

    public void show(){
        System.out.println("I am student");
    }
}
