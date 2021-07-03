package cybersoft.javabackend.java11.gira.project.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

//@FromDateToDate(fromDate="StartDate", toDate="EndDate")
public class UpdateProjectDto {
	@Size(min = 3, max = 100, message = "{project.name.size}")
	private String name;
	
	@Size(min = 3, max = 100, message = "{project.code.size}")
	private String code;
	
	private String icon;
	
	private String description;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	//@ExistsProjectType
	private int projectTypeId;
	
	//@ExistsUser
	private String owner;
	//@ExistsUser
	private String manager;
}
