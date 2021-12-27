package com.example.springtutor.aspect;
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
public class LogAspect {

    @Pointcut("execution(public * com.example.springtutor.controller.MainRestController.*(..))")
    public void MainRest(){}

    @Pointcut("execution(public * com.example.springtutor.controller.ProjectRestController.*(..))")
    public void ProjectRest(){}

    @Pointcut("execution(public * com.example.springtutor.controller.UserProjectRestController.*(..))")
    public void UserProjectRest(){}

    @Before("MainRest()")
    public void beforeMainRest(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("[MainRestController] Начало выполнения");
        log.info("[MainRestController] Параметры=[" + args + "]");
    }

    @Before("ProjectRest()")
    public void beforeProjectRest(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("[ProjectRestController] Начало выполнения");
        log.info("[ProjectRestController] Параметры=[" + args + "]");
    }

    @Before("UserProjectRest()")
    public void beforeUserProjectRest(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("[UserProjectRestController] Начало выполнения");
        log.info("[UserProjectRestController] Параметры=[" + args + "]");
    }

    @After("MainRest()")
    public void afterMainRest(JoinPoint jp) {
        log.info("[MainRestController] Конец выполнения");
    }

    @After("ProjectRest()")
    public void afterProjectRest(JoinPoint jp) {
        log.info("[ProjectRestController] Конец выполнения");
    }

    @After("UserProjectRest()")
    public void afterUserProjectRest(JoinPoint jp) {
        log.info("[UserProjectRestController] Конец выполнения");
    }
}
