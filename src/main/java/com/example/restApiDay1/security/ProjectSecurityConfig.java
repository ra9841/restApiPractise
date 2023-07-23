package com.example.restApiDay1.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		//http.authorizeHttpRequests().anyRequest().authenticated();
		http.csrf().disable().authorizeHttpRequests()
		.mvcMatchers("/rabin","/sabin").authenticated()
		//.mvcMatchers("/pranaya").permitAll()
		.and().formLogin()
		.and().httpBasic();
		return http.build();
	}
	
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailService() {
	 * //InMemoryUserDetailsManager inMemoryUserDetailsManager=new
	 * InMemoryUserDetailsManager(); UserDetails admin=User.withUsername("call")
	 * .password("111") .authorities("admin") .build();
	 * 
	 * UserDetails employee=User.withUsername("shyam") .password("111")
	 * .authorities("employee") .build(); return new
	 * InMemoryUserDetailsManager(admin, employee); }
	 */
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		
		return new JdbcUserDetailsManager(dataSource);
	}
	
	
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return  NoOpPasswordEncoder.getInstance();
	}
	 
	

}
