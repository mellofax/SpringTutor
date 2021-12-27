package com.example.springtutor.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Schema(description = "Регистрация")
public class RegistrationRequest {

    @NotEmpty
    @Schema(description = "Логин", example = "MixailFors")
    private String login;

    @NotEmpty
    @Schema(description = "Пароль", example = "ASg65dsg53")
    private String password;

    @NotEmpty
    @Schema(description = "Почта", example = "asag@mail.ru")
    private String email;

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
