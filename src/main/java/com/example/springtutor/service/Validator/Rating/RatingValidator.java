package com.example.springtutor.service.Validator.Rating;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RatingValidator implements ConstraintValidator<Rating, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("[0-5]{1}$");
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
