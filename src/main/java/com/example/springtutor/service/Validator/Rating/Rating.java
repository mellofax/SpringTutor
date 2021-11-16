package com.example.springtutor.service.Validator.Rating;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingValidator.class)
@Documented
public @interface Rating {
    String message() default "Invalid Rating, Example: 4";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
