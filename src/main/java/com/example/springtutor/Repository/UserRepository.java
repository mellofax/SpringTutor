package com.example.springtutor.Repository;

import com.example.springtutor.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
    User findByEmail(String email);
}
