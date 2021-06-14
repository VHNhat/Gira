package cybersoft.javabackend.java11.gira.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import cybersoft.javabackend.java11.gira.user.util.UserStatus;
import cybersoft.javabackend.java11.gira.user.validation.annotation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

	@NotBlank(message = "{user.username.not-blank}")
	@Size(min = 3, max = 50, message = "{user.username.size}")
	@UniqueUsername
	private String username;
	
	@NotBlank(message = "{user.password.not-blank}")
	@Size(min = 8, max = 100, message = "{user.password.size}")
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String fullname;
	
	@NotBlank
	private String displayName;
	
	@NotNull
	private UserStatus status;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
