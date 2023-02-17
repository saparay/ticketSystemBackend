package com.demo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demo.api.jwt.JwtAuthenticationEntryPoint;
import com.demo.api.jwt.JwtAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

	private UserDetailsService userDetailsService;
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	

	public SecurityConfiguration(UserDetailsService userDetailsService,
			JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAuthenticationFilter jwtAuthenticationFilter) {
		super();
		this.userDetailsService = userDetailsService;
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeHttpRequests(auth ->
		// auth.anyRequest().authenticated()
		auth.requestMatchers(HttpMethod.GET, "/reso/**").permitAll()
		.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.requestMatchers("/auth/**").permitAll()
		.anyRequest().authenticated())
		.exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
			.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		http.httpBasic(Customizer.withDefaults());
		http.headers().frameOptions().sameOrigin();
		http.cors().disable();
		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails mani = User.builder()
//				.username("mani")
//				.password(passwordEncoder().encode("pass"))
//				.roles("USER")
//				.build();
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(passwordEncoder().encode("pass"))
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(mani, admin);
//	}
}
