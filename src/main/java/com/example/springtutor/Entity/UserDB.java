package com.example.springtutor.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
@Data
public class UserDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 4, max = 20,message = "User length: from 4 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String login;

    @Column
    @Size(min=8, max = 32, message="Password must be from 8 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private long password;

    @Column
    @NotNull(message = "Cannot be null")
    private boolean isAdmin;
}
