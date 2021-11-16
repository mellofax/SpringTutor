package com.example.springtutor.service.Validator.Description;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DescriptionValidator implements ConstraintValidator<Description, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]{5,10}$");
        Matcher matcher = pattern.matcher(value);
        try {
            if (!matcher.matches()) {
                return false;
            } else return true;
        } catch (Exception e) {
            return false;
        }
    }
}
