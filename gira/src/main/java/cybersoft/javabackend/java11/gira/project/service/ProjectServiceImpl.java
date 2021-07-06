package cybersoft.javabackend.java11.gira.project.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDto;
import cybersoft.javabackend.java11.gira.project.dto.UpdateProjectDto;
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
public class ProjectServiceImpl extends GenericServiceImpl<Project, Long> implements ProjectService{
	private ProjectRepository repository;
	private ProjectTypeRepository projectTypeRepository;
	private UserRepository userRepository;
	private MapDtoToModel<Object, Project> mapper;
	
	@Override
	public Project save(CreateProjectDto dto) {
		Project model = new Project();
		model = mapper.map(dto, model);
		
		ProjectType type = projectTypeRepository.getOne(dto.getProjectTypeId());
		model.setProjectType(type);
		
		Optional<User>  ownerOpt = userRepository.findByUsername(dto.getOwner());
		if(ownerOpt.isPresent())
			model.setOwner(ownerOpt.get());
		
		Optional<User>  managerOpt = userRepository.findByUsername(dto.getManager());
		if(managerOpt.isPresent())
			model.setManager(managerOpt.get());
		
		return repository.save(model);
	}

	@Override
	public Project update(UpdateProjectDto dto, Long id) {
		Project project = repository.getOne(id);
		project = mapper.map(dto, project);
		
		ProjectType type = projectTypeRepository.getOne(dto.getProjectTypeId());
		project.setProjectType(type);
		
		Optional<User>  ownerOpt = userRepository.findByUsername(dto.getOwner());
		if(ownerOpt.isPresent())
			project.setOwner(ownerOpt.get());
		
		Optional<User>  managerOpt = userRepository.findByUsername(dto.getManager());
		if(managerOpt.isPresent())
			project.setManager(managerOpt.get());
		
		return repository.save(project);
	}

}
