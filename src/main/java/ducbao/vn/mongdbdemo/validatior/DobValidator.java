package ducbao.vn.mongdbdemo.validatior;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DobValidator implements ConstraintValidator<Dobcontrains, LocalDate> {
    private int min;

    @Override
    public void initialize(Dobcontrains constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(localDate)) {
            return true;
        }
        int age = LocalDate.now().getYear() - localDate.getYear();
        return age >= min;
    }
}
