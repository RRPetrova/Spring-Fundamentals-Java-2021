package com.example.mobilele.model.binding;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Constraint(validatedBy = YearPastOrPresentValidation.class)
public @interface YearPastOrPresent {
    String message() default "Invalid year";
    int minYear();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
