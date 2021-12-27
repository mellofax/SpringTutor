package com.example.springtutor.repository;


import com.example.springtutor.bean.UserRole;
import com.example.springtutor.bean.dto.Role;
import com.example.springtutor.exception.RepositoryException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    UserRole findByName(Role name)throws RepositoryException;;
}
