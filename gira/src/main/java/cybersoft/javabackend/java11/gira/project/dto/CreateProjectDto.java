package cybersoft.javabackend.java11.gira.project.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cybersoft.javabackend.java11.gira.util.DateUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectDto {

	@NotBlank(message = "{project.name.not-blank}")
	@Size(min = 3, max = 100, message = "{project.name.size}")
	private String name;
	
	@NotBlank(message = "{project.code.not-blank}")
	@Size(min = 3, max = 7, message = "{project.code.size}")
	private String code;
	
	private String icon;
	
	@NotBlank(message = "{project.description.not-blank}")
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	private LocalDateTime startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	private LocalDateTime endDate;
	
	@NotNull
	private Long projectTypeId;
	
	private String owner;
	
	private String manager;
}
