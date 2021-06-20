package cybersoft.javabackend.java11.gira.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.gira.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.gira.security.dto.LoginDto;
import cybersoft.javabackend.java11.gira.security.jwt.JwtUtils;

@RestController
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@Valid @RequestBody LoginDto dto, BindingResult errors){
		Authentication authentication = null;
		try {
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwtToken = jwtUtils.generateJwtToken(authentication);
			return ResponseHandler.getResponse(jwtToken, HttpStatus.OK);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		return ResponseHandler.getResponse("Username or Password is invalid", HttpStatus.BAD_REQUEST);
	}
}
