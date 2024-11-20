package com.core.concepts;

public class Car {

     Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void start(){
        engine.startEngine();
        System.out.println("Car started...");
    }
}
