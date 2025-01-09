package com.jpa.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<ValidGender,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value==null || value.isEmpty()){
            return false;
        }
        if(value.toLowerCase().equals("male") || value.toLowerCase().equals("female")){
            return true;
        }
        return false;
    }
}
