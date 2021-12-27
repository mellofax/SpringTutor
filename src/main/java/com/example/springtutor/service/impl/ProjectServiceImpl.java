package com.example.springtutor.service.impl;

import com.example.springtutor.bean.Project;
import com.example.springtutor.exception.RepositoryException;
import com.example.springtutor.exception.ServiceException;
import com.example.springtutor.repository.ProjectRepository;
import com.example.springtutor.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public boolean existsByName(String name) throws ServiceException {
        try {
            return projectRepository.existsByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteByName(String name) throws ServiceException {
        try {
            projectRepository.deleteByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void setProjectById(Long id, String name, String description) throws ServiceException {
        try {
            projectRepository.setProjectById(id, name, description);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Project getByName(String name) throws ServiceException {
        try {
            return projectRepository.getByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getById(long id) throws ServiceException {
        try {
            return projectRepository.getById(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
