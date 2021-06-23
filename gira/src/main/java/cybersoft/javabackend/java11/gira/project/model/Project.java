package cybersoft.javabackend.java11.gira.project.model;

import java.time.LocalDateTime;
import java.util.Set;

import cybersoft.javabackend.java11.gira.user.model.User;

public class Project {
	private String name;
	private String code;
	private User owner;
	private User manager;
	private String icon;
	private String description;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private ProjectType ProjectType;
	private Set<Workflow> workflows;
}
