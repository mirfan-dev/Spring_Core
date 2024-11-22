package com.core.autowire;

import com.core.college.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.core")
public class Config {

    @Bean("teacher")
    public Teacher getTeacher(){
        return new Teacher();
    }
}
