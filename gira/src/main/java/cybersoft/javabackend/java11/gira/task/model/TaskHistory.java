package cybersoft.javabackend.java11.gira.task.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_task_history")
public class TaskHistory extends AbstractEntity {
	@NotNull
	private String previousContent;
	@NotNull
	private String currentContent;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Task task;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
