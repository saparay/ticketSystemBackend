package com.demo.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.entity.Login;
import com.demo.api.entity.Register;
import com.demo.api.entity.User;
import com.demo.api.jwt.JwtAuthResponse;
import com.demo.api.service.AuthService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

	private AuthService authService;

	public AuthenticationController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<JwtAuthResponse> login(@RequestBody Login login){
		JwtAuthResponse token = authService.login(login);
//		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
//		jwtAuthResponse.setAccessToken(token);
//		System.out.println("Hello ");
		return ResponseEntity.ok(token);
	}
	
	@PostMapping(path = "/register")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD')")
	public ResponseEntity<String> register(@RequestBody Register register){
		return ResponseEntity.ok(authService.register(register));
	}
	
	@GetMapping(path = "/register")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD')")
	public List<User> retriveUsers(){
		return authService.retriveListUsers();
	}
	
	@DeleteMapping(path = "/register/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD')")
	public void deleteUser(@PathVariable int id) {
		authService.deleteUserById(id);
		
	}
	
//	@GetMapping(path = "/user-role/{username}")
//	public String getUserRole(@PathVariable String username) {
//		
//		return authService.getRole(username);
//	}
}
