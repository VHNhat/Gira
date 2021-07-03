package cybersoft.javabackend.java11.gira.project.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gira_project_workflow_link")
@Getter
@Setter
public class WorkflowLink extends AbstractEntity {
	private String transition;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source")
	private WorkflowNode source;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination")
	private WorkflowNode destination;
	@ManyToOne(fetch = FetchType.LAZY)
	private Workflow workflow;
}
