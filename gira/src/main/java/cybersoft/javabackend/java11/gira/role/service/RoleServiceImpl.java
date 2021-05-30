package cybersoft.javabackend.java11.gira.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository _repository;

	@Override
	public void save(Role role) {
		_repository.save(role);
	}
	
	
}
