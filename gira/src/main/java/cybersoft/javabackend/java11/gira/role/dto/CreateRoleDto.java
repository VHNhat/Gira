package cybersoft.javabackend.java11.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateRoleDto {
	@NotBlank(message = "{role.name.notblank}")
	@Size(min = 4, max = 50, message = "{role.name.size}")
	public String roleName;
	
	@NotBlank(message = "{role.description.notblank}")
	public String description;
	/*
	 * @NotNull -> chỉ check null, không check rỗng
	 * @NotEmpty -> chỉ check rỗng, không check space-trim
	 * @NotBlank -> trim hết space đầu đuôi rồi mới check rỗng
	 */
}
