package com.example.springtutor.DTO;

import com.example.springtutor.Entity.Categorys;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Запись репетитора")
public class RecordDto {
    @Schema(description = "Название", example = "Лучший репетитор")
    private String name;
    @Schema(description = "Описание", example = "Недорого и качественно")
    private String description;
    @Schema(description = "Стоимость", example = "500")
    private int price;
    @Schema(description = "Категории", example = "Русский язык")
    private Categorys category;
}
