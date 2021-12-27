package com.example.springtutor.repository;

import com.example.springtutor.bean.User;
import com.example.springtutor.exception.RepositoryException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login)throws RepositoryException;
    List<User> findAll();
    boolean existsUserByLogin(String login)throws RepositoryException;
    boolean existsUserByLoginAndPassword(String login, String password)throws RepositoryException;
    User getById(Long id);

    User findByActivationCode(String code)throws RepositoryException;
}
