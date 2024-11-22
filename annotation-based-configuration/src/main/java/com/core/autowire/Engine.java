package com.core.autowire;

import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {

    public void getStart(){
        System.out.println("Engine started");
    }
}
