package cybersoft.javabackend.java11.gira.task.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.model.WorkflowNode;
import cybersoft.javabackend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_task")
public class Task extends AbstractEntity {
	
	@NotBlank
	private String code;
	
	@NotBlank
	private String title;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TaskType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User createBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User PIC;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User reporter;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "gira_task_user_watcher",
				joinColumns = @JoinColumn(name = "task_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> watchers = new LinkedList<User>();
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL )
	private Set<Task> subTasks = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Task parent;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private WorkflowNode status;
	
	@OneToOne(mappedBy = "task", cascade = CascadeType.ALL)
	private TaskSchedule schedule;
	
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<Worklog> worklogs = new LinkedList<>();
	
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<Comment> comments = new LinkedList<>();
	
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<TaskHistory> taskHistory = new LinkedList<>();
}
