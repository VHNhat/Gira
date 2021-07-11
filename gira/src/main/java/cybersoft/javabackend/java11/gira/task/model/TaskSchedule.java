package cybersoft.javabackend.java11.gira.task.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_task_schedule")
public class TaskSchedule extends AbstractEntity {
	
	@OneToOne(fetch = FetchType.LAZY)
	private Task task;
	
	private float estimated;
	private LocalDateTime planStartDate;
	private LocalDateTime planEndDate;
	private LocalDateTime actualStartDate;
	private LocalDateTime actualEndDate;
}
