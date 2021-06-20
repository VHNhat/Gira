package cybersoft.javabackend.java11.gira.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.gira.user.dto.CreateUserDto;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
	@Autowired
	private UserRepository _repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public User save(CreateUserDto dto) {
		User user = new User();
		user.username(dto.getUsername())
			.password(passwordEncoder.encode(dto.getPassword()))
			.email(dto.getEmail())
			.fullName(dto.getFullname())
			.displayName(dto.getDisplayName())
			.status(dto.getStatus());
			
		
		return _repository.save(user);
	}
	@Override
	public boolean isTakenUsername(String username) {
		
		return _repository.countByUsername(username) >= 1;
	}
	
	@Override
	public boolean isTakenEmail(String email) {
		return _repository.countByEmail(email) >= 1;
	}

}
