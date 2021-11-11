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
    @Size(min = 4, max = 32, message = "User name have length from 4 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String name;

    @Column
    @Size(min = 4, max = 20,message = "Login length have length from 4 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String login;

    @Column
    @Size(min=8, max = 32, message="Password must be from 8 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String password;

    @Column
    @NotNull(message = "Cannot be null")
    private boolean isAdmin;

    public UserDB(String name, String login,String password, boolean admin) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.isAdmin = admin;
    }

    public UserDB(String name,String login, String password) {
        this.name = name;
        this.password = password;
        this.login = login;
    }

    public UserDB() {
    }

    public boolean AdminCheck(UserDB user){
        if(this.isAdmin == user.isAdmin)
            return true;
        else return false;
    }
}
