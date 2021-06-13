package cybersoft.javabackend.java11.gira.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cybersoft.javabackend.java11.gira.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	int countByUsername(String username);

}
