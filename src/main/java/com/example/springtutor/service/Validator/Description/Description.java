package com.example.springtutor.service.Validator.Description;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DescriptionValidator.class)
@Documented
public @interface Description {
    String message() default "Invalid Login, Example: Hello";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
