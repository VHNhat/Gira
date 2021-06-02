package cybersoft.javabackend.java11.gira.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.gira.role.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByRoleName(String roleName);
	/*
	 * Bài tập: viết hàm tìm theo description và sắp xếp theo role id tăng dần
	 * Gợi ý: dùng từ khóa là contain và orderBy
	 * */
	List<Role> findByDescriptionContainingOrderByIdAsc(String description);
	
	/*
	 * Dùng @Query để viết câu query theo cú pháp của HQL hoặc SQL thuần
	 * */
	/*@Query("SELECT r FROM Role r WHERE r.roleName=:roleName AND r.DESCRIPTION IS NOT NULL")
	List<Role> findRoleWithNotNullDescription(@Param("roleName") String roleName);*/
}
