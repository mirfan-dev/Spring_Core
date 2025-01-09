package com.core;

import com.core.springbeanlifecycle.Car;
import com.core.springbeanlifecycle.config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(config.class);

        Car c=context.getBean("car", Car.class);
        c.start();

        context.close();
    }
}
