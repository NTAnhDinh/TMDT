package com.example.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.config.UserDetailService;
import com.example.demo.dto.EmployeeDto;

@Component
public class UserValidator implements Validator{
@Autowired
UserDetailService userService;
	@Override
	public boolean supports(Class<?> clazz) {
		return EmployeeDto.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		EmployeeDto user = (EmployeeDto) o;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if(user.getUsername().length()>32) {
			errors.rejectValue("username", "user.username.size");
		}
		if(userService.findByName(user.getUsername())!=null) {
			errors.rejectValue("username", "user.username.duplicated");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if((user.getPassword().length()<8|| user.getPassword().length()>32)&& user.getPassword().length()>0) {
			errors.rejectValue("password", "user.password.size");
		}
		if(!user.getPassword().equals(user.getRePassword())) {
			errors.rejectValue("rePassword", "user.password.diff");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idRole", "NotEmpty");
	}

}
