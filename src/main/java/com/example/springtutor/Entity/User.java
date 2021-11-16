package com.example.springtutor.Entity;

import com.example.springtutor.service.Validator.Login.Login;
import com.example.springtutor.service.Validator.Password.Password;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@EqualsAndHashCode(exclude = "tutors")
@ToString(exclude = "tutors")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Email(message = "Incorrect mail format")
    @NotBlank(message = "Cannot be null")
    private String email;

    @Column
    @Login
    private String login;

    @Column
    @Password
    private String password;


    @JsonIgnore
    @OneToMany(mappedBy = "owner", targetEntity = Tutor.class)
    private Set<Tutor> tutors = new HashSet<Tutor>();

    public User(){
    }

    public User(String email, String login, String password) {
        this.email = email;
        this.login = login;
        this.password = password;
    }
}
