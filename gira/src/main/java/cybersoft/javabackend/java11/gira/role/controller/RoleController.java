package cybersoft.javabackend.java11.gira.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	private RoleService _service;
	
	@PostMapping("")
	public ResponseEntity<Object> save(@RequestBody Role role){
		System.out.println(role.toString());
		_service.save(role);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
