package com.demo.api.service;


import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.api.entity.Login;
import com.demo.api.entity.Register;
import com.demo.api.entity.User;
import com.demo.api.jwt.JwtAuthResponse;
import com.demo.api.jwt.JwtTokenProvider;
import com.demo.api.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{

	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
			PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
		super();
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public JwtAuthResponse login(Login login) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsernameOrEmail(), login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtTokenProvider.generateToken(authentication);
		String role = jwtTokenProvider.getRole(authentication);
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setAccessToken(token);
		jwtAuthResponse.setRole(role);
		
		return jwtAuthResponse;
	}

	@Override
	public String register(Register register) {
		
		if(userRepository.existsByUsername(register.getUsername())) {
			return "User already exist";
		}

		
		if(userRepository.existsByEmail(register.getEmail())) {
			return "Email Already exists";
		}
		
		User user = new User();
		user.setFullName(register.getName());
		user.setEmail(register.getEmail());
		user.setUsername(register.getUsername());
		user.setPassword(passwordEncoder.encode(register.getPassword()));
		user.setRoles(register.getRole());
		userRepository.save(user);
		return "User Registered Successfully";
	}

	@Override
	public List<User> retriveListUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

//	@Override
//	public String getRole(String username) {
//		Optional<User> user = userRepository.findByUsername(username);
//		return user.get().getRoles();
//	}

}
