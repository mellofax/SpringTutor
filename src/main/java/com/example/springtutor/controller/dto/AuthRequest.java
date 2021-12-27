package com.example.springtutor.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Авторизация")
public class AuthRequest {
    @Schema(description = "Логин", example = "MixailFors")
    private String login;
    @Schema(description = "Пароль", example = "ASg65dsg53")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
