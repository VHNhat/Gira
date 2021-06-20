package cybersoft.javabackend.java11.gira.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java11.gira.user.validation.validator.ConfirmPasswordValidator;


@Constraint(validatedBy = ConfirmPasswordValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPassword {
	public String getPassword() default "get Password";
	
	public String getConfirmPassword() default "get Confirm Password";
	
	public String message() default "Password is already used.";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload> [] payload() default {};
}
