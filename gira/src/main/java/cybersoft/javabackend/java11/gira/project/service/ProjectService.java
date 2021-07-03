package cybersoft.javabackend.java11.gira.project.service;

import javax.validation.Valid;

import cybersoft.javabackend.java11.gira.commondata.GenericService;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDto;
import cybersoft.javabackend.java11.gira.project.model.Project;

public interface ProjectService extends GenericService<Project, Long> {

	Project save(@Valid CreateProjectDto dto);

}
