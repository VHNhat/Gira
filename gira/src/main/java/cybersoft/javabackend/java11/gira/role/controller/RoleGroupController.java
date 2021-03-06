package cybersoft.javabackend.java11.gira.role.controller;

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

import cybersoft.javabackend.java11.gira.role.dto.CreateRoleGroupDto;
import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.model.RoleGroup;
import cybersoft.javabackend.java11.gira.role.service.RoleGroupService;

@RestController
@RequestMapping("/api/role-group")
public class RoleGroupController {
	@Autowired
	private RoleGroupService _service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllGroups(){
		List<RoleGroup> roleGroups = _service.findAll();
		
		if(roleGroups == null)
			return new ResponseEntity<>(roleGroups, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(roleGroups, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> saveRoleGroup(@Valid @RequestBody CreateRoleGroupDto dto, BindingResult errors){
		if(errors.hasErrors())
			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		
		RoleGroup roleGroups = new RoleGroup()
											  .name(dto.roleGroupName)
											  .description(dto.description);
		
		_service.save(roleGroups);
		
		return new ResponseEntity<>(roleGroups, HttpStatus.CREATED);
	}
	
	@PutMapping("/{group-id}/role")
	public ResponseEntity<Object> addRoleToGroup(@Valid @RequestBody Role role, @PathVariable("group-id") Long groupId, BindingResult errors){
		if(errors.hasErrors())
			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		
		RoleGroup updatedGroup = _service.addRole(role, groupId);
		
		return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
	}
}
