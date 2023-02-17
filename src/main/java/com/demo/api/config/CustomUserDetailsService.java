package com.demo.api.config;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.api.entity.User;
import com.demo.api.exception.UserNotFoundException;
import com.demo.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
				() -> new UserNotFoundException("User not found with username or email: " + usernameOrEmail));
		SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(user.getRoles());

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				Arrays.asList(authorities));
	}

}