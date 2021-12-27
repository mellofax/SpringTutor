package com.example.springtutor.repository;

import com.example.springtutor.bean.UserProject;
import com.example.springtutor.exception.RepositoryException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserProjectRepository extends JpaRepository<UserProject,Long>
{
    boolean existsByUserIdAndProjectId(Long user_id, long project_id)throws RepositoryException;
    boolean existsByProjectId(long project_id)throws RepositoryException;
    List<UserProject> getAllByUserLogin(String user_login)throws RepositoryException;
    @Modifying
    @Query("update UserProject up set up.isDenide =:isDenide,up.isSet =:isSet where up.id =:id ")
    void setUserProjectById(
            @Param("id") Long id,
            @Param("isDenide") boolean isDenide,
            @Param("isSet") boolean isSet
    )throws RepositoryException;

    UserProject getById(long id);
}
