package cybersoft.javabackend.java11.gira.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.gira.role.model.RoleGroup;

@Repository
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Long> {
	
}
