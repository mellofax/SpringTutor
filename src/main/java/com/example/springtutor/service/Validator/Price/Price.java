package com.example.springtutor.service.Validator.Price;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriceValidator.class)
@Documented
public @interface Price {
    String message() default "Invalid Price, Example: 543";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
