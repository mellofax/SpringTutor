package com.example.springtutor.Forms;

import com.example.springtutor.Entity.Categorys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordForm {
    private String name;
    private String description;
    private int price;
    private Categorys category;
}
