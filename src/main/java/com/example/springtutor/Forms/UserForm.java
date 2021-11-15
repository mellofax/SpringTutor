package com.example.springtutor.Forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String email;
    private String login;
    private String password;
    private boolean isAdmin;
}
