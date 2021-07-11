package cybersoft.javabackend.java11.gira.task.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.project.model.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_task_type")
public class TaskType extends AbstractEntity {
	@NotBlank
	private String code;
	
	@NotBlank
	private String name;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;
	
	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
	private List<Task> tasks = new LinkedList<>();
}
