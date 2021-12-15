package com.example.mobilele.util;

public interface ValidationUtil {

    <E> boolean isValid(E entity);
    //<E> Set<ConstraintViolation<E>> violation(E entity);
}
