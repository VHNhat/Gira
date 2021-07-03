package cybersoft.javabackend.java11.gira.project.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "gira_project")
@Getter
@Setter
public class Project extends AbstractEntity {
	
		// @NotNull : chỉ check null
		// @NotEmpty : chỉ check null và length của string
		// , string " " vẫn trả về true
		// @NotBlank : check null, sau đó trim space pre,suff trước khi check length
		@NotBlank(message = "{project.name.not-blank}")
		@Size(min = 3, max = 100, message = "{project.name.size}")
		@Column(unique = true)
		private String name;
		
		@NotBlank(message = "{project.code.not-blank}")
		@Size(min = 3, max = 7, message = "{project.code.size}")
		@Column(unique = true)
		private String code;
		/*
		 * Cybersoft Gira Education Project
		 * CGEP
		 * CGEP-4
		 */
		
		private String icon;
		
		@NotBlank(message = "{project.description.not-blank}")
		private String description;
		
		private LocalDateTime startDate;
		private LocalDateTime endDate;
		
		// redundant code -> Dốt mà hay nói chữ
		// bidirectional
		// ManyToOne, OneToMany, OneToOne: EAGER
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(referencedColumnName = "username")
		private User owner;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(referencedColumnName = "username")
		private User manager;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@NotNull
		@JsonIgnore
		private ProjectType projectType; // PRODUCT, MAINTAIN, SERVICE / 1, 2, 3
		
		@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
		@JsonIgnore
		private List<Workflow> workflows = new ArrayList<>(); 
	
}
