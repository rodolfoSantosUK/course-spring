package com.spring.course.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy; 
 

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter  {

	
	//Configuracoes de autorizacao
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers(HttpMethod.GET,  "/users").permitAll()
			.antMatchers(HttpMethod.GET,  "/users/*").permitAll() 
			.antMatchers(HttpMethod.GET,  "/h2-console/**").permitAll() 
			.antMatchers(HttpMethod.GET,  "/h2-console/*").permitAll() 			
			.and().headers().frameOptions().sameOrigin()
		    .and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  
		}
	
}
