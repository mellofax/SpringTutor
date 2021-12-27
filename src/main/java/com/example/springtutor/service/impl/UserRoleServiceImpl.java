package com.example.springtutor.service.impl;

import com.example.springtutor.bean.UserRole;
import com.example.springtutor.bean.dto.Role;
import com.example.springtutor.exception.RepositoryException;
import com.example.springtutor.exception.ServiceException;
import com.example.springtutor.repository.UserRoleRepository;
import com.example.springtutor.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public UserRole findByName(Role name)throws ServiceException {
        try {
            return userRoleRepository.findByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
