package com.cartisan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity {

    public List<String> validate() {
        List<String> errorMessages = new ArrayList<String>();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<BaseEntity>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<BaseEntity> violation : violations) {
                errorMessages.add(violation.getMessage());
            }
        }

        return errorMessages;
    }
}