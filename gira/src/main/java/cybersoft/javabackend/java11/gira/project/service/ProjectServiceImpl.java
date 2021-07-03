package cybersoft.javabackend.java11.gira.project.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDto;
import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.model.ProjectType;
import cybersoft.javabackend.java11.gira.project.repository.ProjectRepository;
import cybersoft.javabackend.java11.gira.project.repository.ProjectTypeRepository;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;
import cybersoft.javabackend.java11.gira.util.MapDtoToModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, Long> implements ProjectService {
	private ProjectRepository repository;
	private ProjectTypeRepository projectTypeRepository;
	private UserRepository userRepository;
	private MapDtoToModel mapper;
	@Override
	public Project save(@Valid CreateProjectDto dto) {
		Project model = new Project();
		model = (Project) mapper.map(dto, model);
		
		ProjectType type = projectTypeRepository.getOne(dto.getProjectTypeId());
		model.setProjectType(type);
		
		Optional<User> ownerOpt = userRepository.findByUsername(dto.getOwner());
		
		if(ownerOpt.isPresent())
			model.setOwner(ownerOpt.get());
		
		Optional<User> managerOpt = userRepository.findByUsername(dto.getOwner());
		
		if(ownerOpt.isPresent())
			model.setOwner(managerOpt.get());
		
		return repository.save(model);
	}

}
