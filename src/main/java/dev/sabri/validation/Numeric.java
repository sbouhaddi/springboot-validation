package dev.sabri.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NumericValidator.class)
public @interface Numeric {

    String message() default "Invalid numeric value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}