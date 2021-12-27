package com.example.springtutor.service;

import com.example.springtutor.bean.UserProject;
import com.example.springtutor.exception.ServiceException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UserProjectService {
    boolean existsByUserIdAndProjectId(Long user_id, long project_id)throws ServiceException;
    boolean existsByProjectId(long project_id)throws ServiceException;
    List<UserProject> getAllByUserLogin(String user_login)throws ServiceException;
    UserProject create(UserProject userProject)throws ServiceException;
    List<UserProject> getAll()throws ServiceException;
    @Transactional
    void setUserProjectById(
            @Param("id") Long id,
            @Param("isDenide") boolean isDenide,
            @Param("isSet") boolean isSet)throws ServiceException;

}
