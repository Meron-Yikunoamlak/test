package et.com.meron.service.employeeService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomValidation<T> {

    public Set<ConstraintViolation<T>> getConstraintViolations(T t) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(t);
//        if (!violations.isEmpty()) {
//            throw new ConstraintViolationException(violations);
//            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, new ResponseDto(HttpStatus.BAD_REQUEST, new ConstraintViolationException(violations).getMessage(), null).toString());
//        }

        return violations;

    }

}
