package com.core.autowire;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {

    @Autowired
    Engine engine;

//    @Autowired
    public Car(Engine engine){
        this.engine=engine;
    }

    public Car(){

    }

    public Engine getEngine() {
        return engine;
    }
//    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start(){
        engine.getStart();
        System.out.println("Car started");
    }
}
