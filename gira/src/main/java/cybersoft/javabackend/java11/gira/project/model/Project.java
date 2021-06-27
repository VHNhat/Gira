package cybersoft.javabackend.java11.gira.project.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "gira_project")
@Getter
@Setter
public class Project extends AbstractEntity {
	
	@NotBlank(message = "{project.name.not-blank}")
	@Size(min = 3, max = 100, message = "{project.name.size}")
	@Column(unique = true)
	private String name;
	
	@NotBlank(message = "{project.code.not-blank}")
	@Size(min = 3, max = 100, message = "{project.code.size}")
	@Column(unique = true)
	private String code;
	
	// ManyToOne, OneToMany, OneToOne: default = EAGER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "username")
	private User owner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "username")
	private User manager;
	
	private String icon;
	
	@NotBlank(message = "{project.description.not-blank}")
	private String description;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private ProjectType projectType;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private Set<Workflow> workflows = new HashSet<>();
	
}
