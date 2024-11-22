package com.core;

import com.core.concepts.Config;
import com.core.concepts.DataSource;
import com.core.concepts.HibernateTemplate;
import com.core.concepts.SessionFactory;
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

        DataSource source=context.getBean("data",DataSource.class);
        source.getDataSource();
        System.out.println("============================");

        SessionFactory session=context.getBean("session",SessionFactory.class);
        session.getSessionFactory();
        System.out.println("==========================");

        HibernateTemplate hibernateTemplate=context.getBean("hibernate",HibernateTemplate.class);
        hibernateTemplate.getHibernateTemplate();
    }
}
