package cybersoft.javabackend.java11.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoleDto {
	@NotBlank(message = "{role.name.notblank}")
	@Size(min = 4, max = 50, message = "{role.name.size}")
	private String roleName;
	
	@NotBlank(message = "{role.description.notblank}")
	private String description;
	/*
	 * @NotNull -> chỉ check null, không check rỗng
	 * @NotEmpty -> chỉ check rỗng, không check space-trim
	 * @NotBlank -> trim hết space đầu đuôi rồi mới check rỗng
	 */

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
