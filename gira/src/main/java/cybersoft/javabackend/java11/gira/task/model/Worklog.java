package cybersoft.javabackend.java11.gira.task.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_worklog")
public class Worklog extends AbstractEntity {
	@NotNull
	private LocalDateTime startDate;
	
	@DecimalMin(value = "0.1")
	private float duration;
	
	private String works;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Task task;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
