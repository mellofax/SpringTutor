package com.example.springtutor.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Пользователь")
public class UserDto {
    @Schema(description = "Почта", example = "hegras@gmail.com")
    private String email;
    @Schema(description = "Логин", example = "murfos21")
    private String login;
    @Schema(description = "Пароль", example = "fASgds345")
    private String password;
}
