package com.example.mobilele.model.binding;

import com.example.mobilele.model.binding.YearPastOrPresent;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.YearMonth;

public class YearPastOrPresentValidation
        implements ConstraintValidator<YearPastOrPresent, Integer> {
    private int minYear;

    @Override
    public void initialize(YearPastOrPresent constraintAnnotation) {
        this.minYear = constraintAnnotation.minYear();
    }

    @Override
    public boolean isValid(Integer inputYear, ConstraintValidatorContext context) {
        if (inputYear == null) {
            return false;
        }
        int currentYear = YearMonth.now().getYear();
        return inputYear >= minYear && inputYear <= currentYear;
    }
}
