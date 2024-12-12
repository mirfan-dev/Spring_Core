package com.thymleaf.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class before_and_after {


    @Before("execution(* com.thymleaf.controller.BlogController.blog(..))")
    public void logging(){
        System.out.println("Hi method starting");
    }

    @After("execution(* com.thymleaf.controller.BlogController.blog(..))")
    public void terminating(){
        System.out.println("Method Terminating");
    }
}
