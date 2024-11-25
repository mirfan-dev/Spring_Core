package com.core.springbeanlifecycle;

import org.springframework.stereotype.Component;

@Component
public class Engine {

    public void startEngine(){
        System.out.println("Engine started");
    }
}
