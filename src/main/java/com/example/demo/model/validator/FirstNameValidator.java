package com.example.demo.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FirstNameValidator implements ConstraintValidator<FirstName,String>{

	@Override
	public void initialize(FirstName arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String fName, ConstraintValidatorContext arg1) {
		char ch = fName.charAt(0);
		return Character.isUpperCase(ch);
	}


}
