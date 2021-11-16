package com.example.springtutor.service.Log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LogRegistrationControllerAspect {
    @Pointcut("execution(public * com.example.springtutor.Controller.RegistrationController.*(..))")
    public void callAtUserService(){}

    @Before("callAtUserService()")
    public void beforeCallMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("before " + jp.toString() + ", args=[" + args + "]");

    }

    @After("callAtUserService()")
    public void afterCallAt(JoinPoint jp) {
        log.info("after " + jp.toString());
    }
}