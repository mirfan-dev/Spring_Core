package com.core;

import com.core.custombeanlifecycle.Config;
import com.core.custombeanlifecycle.UserDao;
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

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Config.class);

        UserDao dao=context.getBean("dao", UserDao.class);
        dao.saveUser();
        context.close();
    }
}
