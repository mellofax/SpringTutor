package com.example.springtutor.service;

import com.example.springtutor.bean.UserRole;
import com.example.springtutor.bean.dto.Role;
import com.example.springtutor.exception.RepositoryException;
import com.example.springtutor.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {
    UserRole findByName(Role name)throws ServiceException, RepositoryException;
}
