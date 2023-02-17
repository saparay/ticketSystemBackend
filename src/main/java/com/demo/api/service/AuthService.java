package com.demo.api.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.demo.api.entity.Login;
import com.demo.api.entity.Register;
import com.demo.api.entity.User;
import com.demo.api.jwt.JwtAuthResponse;

public interface AuthService {
	
	JwtAuthResponse login(Login login);
	String register(Register register);
	
	List<User> retriveListUsers();
	
	void deleteUserById(int id);

}
