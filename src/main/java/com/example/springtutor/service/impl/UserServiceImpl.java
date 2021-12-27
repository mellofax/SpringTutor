package com.example.springtutor.service.impl;


import com.example.springtutor.bean.User;
import com.example.springtutor.bean.UserRole;
import com.example.springtutor.bean.dto.Role;
import com.example.springtutor.exception.RepositoryException;
import com.example.springtutor.exception.ServiceException;
import com.example.springtutor.repository.UserRepository;
import com.example.springtutor.repository.UserRoleRepository;
import com.example.springtutor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailSenderImpl mailSender;

    public User saveUser(User user) throws ServiceException {
        try {
            UserRole userRole = userRoleRepository.findByName(Role.ROLE_USER);
            user.setUserRole(userRole);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setActivationCode(UUID.randomUUID().toString());

            user.setActive(false);
            String message = String.format(
                    "Hello %s!\n" +
                            "activate your code , need to visit http://localhost:8085/activate/%s",
                    user.getLogin(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(), "Activation code", message);
            return userRepository.save(user);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public User findByLogin(String login) throws ServiceException {
        try {
            return userRepository.findByLogin(login);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByLoginAndPassword(String login, String password) throws ServiceException {
        User user = findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public boolean existsUserByLogin(String login) throws ServiceException {
        try {
            return userRepository.existsUserByLogin(login);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public boolean existsUserByLoginAndPassword(String login, String password) throws ServiceException {
        return findByLoginAndPassword(login, password) != null;
    }

    @Override
    public User findById(long id) {
        return userRepository.getById(id);
    }


    public void activateUser(String code) throws ServiceException {
        try {
            User user = userRepository.findByActivationCode(code);
            if (user != null) {
                user.setActivationCode(null);
                user.setActive(true);
                userRepository.save(user);
            }
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
