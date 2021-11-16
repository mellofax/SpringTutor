package com.example.springtutor.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Репетитор")
public class TutorDto {
    @Schema(description = "Ф.И.О", example = "Грошев Михаил Николаевич")
    private String name;
    @Schema(description = "Рейтинг", example = "4")
    private int rating;
    @Schema(description = "Репетиторы пользователя")
    private UserDto owner;
}
