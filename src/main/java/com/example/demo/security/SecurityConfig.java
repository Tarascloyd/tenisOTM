package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	    throws Exception {

	  auth
	    .userDetailsService(userDetailsService)
	    .passwordEncoder(encoder());
	    
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	    .authorizeRequests()
	      .antMatchers("/match/play", "/players/**", "/tournament/play")
	        .access("hasRole('ROLE_USER')")
	      .antMatchers("/", "/**").access("permitAll")
	    
	    .and()
	      .formLogin()
	        .loginPage("/login")
	        .failureUrl("/login-error")
	       
	    .and()
	      .logout()
	        .logoutSuccessUrl("/");
	}
}
