package com.core.concepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hibernate")
public class HibernateTemplate {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public  void getHibernateTemplate(){
        sessionFactory.getSessionFactory();
        System.out.println("HibernateTemplate start");
    }
}
