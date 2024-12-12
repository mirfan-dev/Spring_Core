package com.thymleaf.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class around {

    @Around("execution(* com.thymleaf.controller.*.*(..))")
    public Object measureTimeToRun(ProceedingJoinPoint joinPoint) throws Throwable {

        Long start=System.currentTimeMillis();
        Object object=joinPoint.proceed();

        long end=System.currentTimeMillis();

        System.out.println("Time taken by logic  "+joinPoint.getSignature()+" to execute " +(end-start)+" ms");
    return object;

    }
}
