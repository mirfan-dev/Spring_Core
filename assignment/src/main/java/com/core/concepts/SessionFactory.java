package com.core.concepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("session")
public class SessionFactory {

    @Autowired
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void getSessionFactory(){
        dataSource.getDataSource();
        System.out.println("SessionFactory start");
    }
}
