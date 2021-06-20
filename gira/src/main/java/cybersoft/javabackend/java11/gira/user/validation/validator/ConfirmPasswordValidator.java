package cybersoft.javabackend.java11.gira.user.validation.validator;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java11.gira.user.validation.annotation.ConfirmPassword;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, Object> {
	private String message;
	private String getPassword;
	private String getConfirmPassword;
	
	
	@Override
	public void initialize(ConfirmPassword constraintAnnotation) {
		this.message = constraintAnnotation.message();
		this.getPassword = constraintAnnotation.getPassword();
		this.getConfirmPassword = constraintAnnotation.getConfirmPassword();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			String password = (String)value.getClass().getMethod(getPassword).invoke(value);
			String connfirmPassword = (String)value.getClass().getMethod(getConfirmPassword).invoke(value);
			
			if(password.equals(connfirmPassword))
				return true;
			
			context.buildConstraintViolationWithTemplate(message)
				   .addConstraintViolation()
				   .disableDefaultConstraintViolation();
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
