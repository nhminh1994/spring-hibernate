package minh.training.springhibernate.validators.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import minh.training.springhibernate.validators.PhoneValidator;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Retention( RetentionPolicy.RUNTIME )
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Phone {
  String message() default "{Phone}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}