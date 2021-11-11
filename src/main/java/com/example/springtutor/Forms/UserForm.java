package com.example.springtutor.Forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String name;
    private String login;
    private String password;
    private String reppass;
}
