package cybersoft.javabackend.java11.gira.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.gira.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDto;
import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	private ProjectService service;
	@GetMapping("")
	public ResponseEntity<Object> findAllProjects(){
		List<Project> projects = service.findAll();
		
		if(projects.isEmpty())
			return ResponseHandler.getResponse("There is no data", HttpStatus.OK);
		
		return ResponseHandler.getResponse(projects, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createNewProject(@Valid @RequestBody CreateProjectDto dto, BindingResult errors){
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
//		Project project = service.save(dto);
		
		return ResponseHandler.getResponse(HttpStatus.OK);
	}
}
