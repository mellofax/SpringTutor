package com.example.springtutor.aspect;

import com.example.springtutor.bean.User;
import com.example.springtutor.exception.RepositoryException;
import com.example.springtutor.exception.ServiceException;
import com.example.springtutor.repository.UserRepository;
import com.example.springtutor.service.UserService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = Logger.getLogger(UserServiceAspect.class);

    @Pointcut("execution(public * com.example.springtutor.service.UserService.findById(..))")
    public void callAtUserServiceFindById() {
    }

    @Pointcut("execution(public * com.example.springtutor.service.UserService.existsUserByLogin(..))")
    public void callAtUserServiceExistsUserByLogin() {
    }

    @Before("callAtUserServiceFindById()")
    public void beforeCallAtUserServiceSaveUser(JoinPoint jp) throws ServiceException, RepositoryException {
        Object[] objects = jp.getArgs();
        long id = (long) objects[0];
        logger.info("user id = " + id);
    }

    @Before("callAtUserServiceExistsUserByLogin()")
    public void beforeCallAtUserServiceExistsUserByLogin(JoinPoint jp) throws ServiceException, RepositoryException {
        Object[] objects = jp.getArgs();
        String login = (String) objects[0];
        User result = userService.findByLogin(login);
        logger.info("is user exist = " + result);

    }

    @After("callAtUserServiceExistsUserByLogin()")
    public void afterCallAtUserServiceExistsUserByLogin(JoinPoint jp) {
        logger.info("After callAtUserServiceExistsUserByLogin");
    }

    @After("callAtUserServiceFindById()")
    public void afterCallAtUserServiceSaveUser(JoinPoint jp) {
        logger.info("After callAtUserServiceSaveUser");
    }
}
