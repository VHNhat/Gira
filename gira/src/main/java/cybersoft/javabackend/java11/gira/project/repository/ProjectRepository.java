package cybersoft.javabackend.java11.gira.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	
	// HQL
	/*
	 * EntityGraph có thể sử dụng chung với câu query viết bằng HQL
	 * EntityGraph không thể sử dụng với câu query native
	 */
	@EntityGraph(attributePaths = {"owner.roleGroups.roles", "manager", "projectType", "workflows"},
			type = EntityGraphType.FETCH)
	@Query(value = "SELECT p FROM Project p WHERE p.projectType = ?1")
	public List<Project> findAllByType(ProjectType type);
	
	/*
	 * Nên ưu tiên sử dụng JOIN FETCH hơn Entity Graph
	 * Entity Graph chỉ nên được sử dụng trong trường hợp mà bạn không có cách nào viết JOIN FETCH
	 */
	@Query(value = "SELECT p FROM Project p JOIN FETCH p.owner WHERE p.projectType = ?1")
	public List<Project> findAllByTypeJoinFetch(ProjectType type);
	
	
	public List<Project> findAllByProjectType(ProjectType type);
	
}
