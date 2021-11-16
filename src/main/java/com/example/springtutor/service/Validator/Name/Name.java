package com.example.springtutor.service.Validator.Name;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface Name {
    String message() default "Invalid Name, Example: Репетиторство";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
