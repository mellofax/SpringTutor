package com.example.springtutor.service.Validator.Login;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginValidator.class)
@Documented
public @interface Login {
    String message() default "Invalid Login, Example: Ag56ds43";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
