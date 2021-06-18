package cybersoft.javabackend.java11.gira.user.service;


import cybersoft.javabackend.java11.gira.commondata.GenericService;
import cybersoft.javabackend.java11.gira.user.dto.CreateUserDto;
import cybersoft.javabackend.java11.gira.user.model.User;

public interface UserService extends GenericService<User, Long> {

	User save(CreateUserDto dto);

	boolean isTakenUsername(String username);

}
