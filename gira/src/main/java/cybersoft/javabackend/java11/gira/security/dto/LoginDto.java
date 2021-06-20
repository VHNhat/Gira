package cybersoft.javabackend.java11.gira.security.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	
	
}
