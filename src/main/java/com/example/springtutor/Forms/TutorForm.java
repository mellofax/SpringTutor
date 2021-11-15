package com.example.springtutor.Forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorForm {
    private String name;
    private int rating;
    private UserForm owner;
}
