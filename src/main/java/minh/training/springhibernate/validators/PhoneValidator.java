package minh.training.springhibernate.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import minh.training.springhibernate.annotations.Phone;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
	public void initialize(Phone paramA) {
	}

	public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
		if (phoneNo == null)
			return false;
		if (phoneNo.startsWith("+"))
			return phoneNo.length() == 12;
		if (phoneNo.startsWith("0"))
			return phoneNo.length() == 10;
		return false;
	}
}