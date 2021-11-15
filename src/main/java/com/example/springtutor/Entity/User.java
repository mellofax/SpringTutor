package com.example.springtutor.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min = 4, max = 32, message = "User email must contain from 6 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String email;

    @Column
    @Size(min = 4, max = 20,message = "User login must contain from from 4 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String login;

    @Column
    @Size(min=8, max = 32, message="User password must contain from 8 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String password;

    @Column
    @NotNull(message = "Cannot be null")
    private boolean isAdmin;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", targetEntity = Tutor.class)
    private Set<Tutor> tutors = new HashSet<Tutor>();

    public User(){
    }

    public User(String email, String login, String password, boolean isAdmin) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
