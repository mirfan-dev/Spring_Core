package com.core.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("human")
public class Human {

//    @Autowired
//    @Qualifier("sprite")
    ColdDrink coldDrink;


    @Autowired
    @Qualifier("sprite")
    public void setColdDrink(ColdDrink coldDrink) {
        this.coldDrink = coldDrink;
    }

    public ColdDrink getColdDrink() {
        return coldDrink;
    }

    public void drinkHuman(){
        coldDrink.drink();
    }
}
