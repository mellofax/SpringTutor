package com.example.springtutor.service;

import com.example.springtutor.bean.User;
import com.example.springtutor.exception.RepositoryException;
import com.example.springtutor.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user) throws ServiceException, RepositoryException;

    User findByLogin(String login) throws ServiceException, RepositoryException;

    List<User> findAll()throws ServiceException, RepositoryException;

    User findByLoginAndPassword(String login, String password) throws ServiceException, RepositoryException;

    boolean existsUserByLogin(String login)throws ServiceException;

    boolean existsUserByLoginAndPassword(String login, String password)throws ServiceException;

    User findById(long id)throws ServiceException;
}
