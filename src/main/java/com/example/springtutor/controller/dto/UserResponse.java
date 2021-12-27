package com.example.springtutor.controller.dto;


import com.example.springtutor.bean.dto.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Получить всех пользователей")
public class UserResponse {
    @Schema(description = "Идентификатор", example = "4")
    private Long id;
    @Schema(description = "Логин", example = "MixailFors")
    private String login;
    @Schema(description = "Полномочия", example = "ROLE_USER")
    private Role role;

    public UserResponse(Long id, String login, Role role) {
        this.id = id;
        this.login = login;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
