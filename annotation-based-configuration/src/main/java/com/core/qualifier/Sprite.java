package com.core.qualifier;


import org.springframework.stereotype.Component;

@Component("sprite")
public class Sprite implements ColdDrink{
    @Override
    public void drink() {
        System.out.println("Drinking Sprite");
    }
}
