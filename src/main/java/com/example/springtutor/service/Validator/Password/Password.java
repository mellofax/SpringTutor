package com.example.springtutor.service.Validator.Password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface Password {
    String message() default "Invalid Password, Example: Ag56ds43";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
