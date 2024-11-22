package com.core.concepts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {

    @Autowired         // You car inject dependeny using three way 1.Constructor, 2. Setter, 3.Field
    Engine engine;

//    @Autowired
    public Car(Engine engine){
        this.engine=engine;
    }
    public Car(){

    }

//    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }


    public Engine getEngine() {
        return engine;
    }

    public void start(){
        engine.getEngine();
        System.out.println("Car started");
    }
}
