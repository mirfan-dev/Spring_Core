package com.core;

import com.core.autowire.Car;
import com.core.autowire.Config;
import com.core.autowire.Engine;
import com.core.primary.NotificationService;
import com.core.qualifier.Human;
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
        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);

        Engine e=context.getBean("engine", Engine.class);
        e.getStart();
        System.out.println("=========");

        Car c=context.getBean("car",Car.class);
        c.start();

        Human h=context.getBean("human", Human.class);
        h.drinkHuman();

        NotificationService service=context.getBean("service",NotificationService.class);
        service.notification();
    }
}
