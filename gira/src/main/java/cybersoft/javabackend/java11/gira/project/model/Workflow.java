package cybersoft.javabackend.java11.gira.project.model;

import java.util.Set;

public class Workflow {
	private String name;	
	private String description;
	private Set<WorkflowNode> nodes;
	private Set<WorkflowLink> links;
	private Project project;
}
