package com.example.springtutor.Repository;

import com.example.springtutor.Entity.UserDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDB, Long> {}
