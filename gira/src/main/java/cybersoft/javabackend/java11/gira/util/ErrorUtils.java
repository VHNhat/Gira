package cybersoft.javabackend.java11.gira.util;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.ObjectError;

public class ErrorUtils {
	
	public static List<String> getErrorMessages(List<ObjectError> errors){
		List<String> messages = new LinkedList<>();
		
		for (ObjectError error : errors) {
			messages.add(error.getDefaultMessage());
		}
		
		return messages;
		
	}
	
	public static List<String> errorOf(String message){
		List<String> messages = new LinkedList<String>();
		messages.add(message);
		return messages;
	}
}
