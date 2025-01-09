package com.core.springbeanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("car")
public class Car implements InitializingBean , DisposableBean {

    Engine engine;

    public Car() {
    }
    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start(){
        engine.startEngine();
        System.out.println("Car started");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("we are in after properties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Car bean is going to be destroy");
    }
}
