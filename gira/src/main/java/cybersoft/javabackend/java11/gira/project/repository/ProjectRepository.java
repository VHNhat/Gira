package cybersoft.javabackend.java11.gira.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.model.ProjectType;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	// ad-hoc entity graph
	@Override
	@EntityGraph(attributePaths = {"owner.roleGroups.roles", "manager", "projectType", "workflows"},
				type = EntityGraphType.FETCH)
	public List<Project> findAll();
	
//	@Query(value = "SELECT p FROM Project p WHERE p.projectType = ")
//	public List<Project> findAllByType(ProjectType type);
	
	public List<Project> findAllByProjectType(ProjectType type);
	
}