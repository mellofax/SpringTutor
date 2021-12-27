package com.example.springtutor.service;

import com.example.springtutor.bean.Project;
import com.example.springtutor.exception.ServiceException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface ProjectService {
    boolean existsByName(String name)throws ServiceException;
    @Transactional
    void deleteByName(String name)throws ServiceException;
    @Transactional
    void setProjectById(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("description") String description) throws ServiceException;
    Project getByName(String name)throws ServiceException;
    List<Project> findAll()throws ServiceException;
    Project create(Project project)throws ServiceException;
    Project getById(long id)throws ServiceException;
}
