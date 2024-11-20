package com.core;

import com.core.concepts.UserController;
import com.core.concepts.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");

        UserService service=context.getBean("service", UserService.class);
        service.executeService();
        System.out.println("============================");

        UserController controller=context.getBean("controller",UserController.class);
        controller.executeController();
    }
}
