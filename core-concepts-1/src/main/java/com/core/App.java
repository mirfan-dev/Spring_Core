package com.core;

import com.core.concepts.Email;
import com.core.concepts.NotificationService;
import com.core.concepts.Sms;
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

        Email e=context.getBean("email", Email.class);
        e.notifyUser();
        System.out.println("==================");

        Sms s=context.getBean("sms", Sms.class);
        s.notifyUser();
        System.out.println("==================");

        NotificationService service=context.getBean("service",NotificationService.class);
        service.sendNotification();
    }
}
