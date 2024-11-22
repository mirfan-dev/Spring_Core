package com.core.concepts;

import org.springframework.stereotype.Component;

@Component("data")
public class DataSource {

    public void getDataSource(){
        System.out.println("DataSource start");
    }
}
