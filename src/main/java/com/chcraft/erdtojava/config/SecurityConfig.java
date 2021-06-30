package com.chcraft.erdtojava.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests()
		    .antMatchers("**/**").permitAll()
			.antMatchers("/java").permitAll()
			.antMatchers("/sql/*").permitAll()
			.and()
			.formLogin().disable();

	}


}
