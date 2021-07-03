package cybersoft.javabackend.java11.gira.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.gira.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDto;
import cybersoft.javabackend.java11.gira.project.dto.UpdateProjectDto;
import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.service.ProjectService;
import cybersoft.javabackend.java11.gira.util.MapDtoToModel;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/project")
@AllArgsConstructor
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
	public ResponseEntity<Object> createNewProject(@Valid @RequestBody CreateProjectDto dto,
												BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
	
		Project project = service.save(dto);
		return ResponseHandler.getResponse(project, HttpStatus.OK);
	}
	
	// update
//	@PutMapping("/{project-id}")
//	public ResponseEntity<Object> updateProject(@PathVariable("project-id")Long id,
//											@Valid @RequestBody UpdateProjectDto dto,
//											BindingResult bindingResult){
//		if(id == null)
//			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
//		
//		if(bindingResult.hasErrors())
//			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
//		
//		int updateResult = service.update(dto, id);
//		
//		if(updateResult > 0)
//			return ResponseHandler.getResponse(HttpStatus.OK);
//		
//		return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
//	}
	
	// delete
	
}
