package com.Spring.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailDao userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().and().httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/domain_controller/**").hasRole("DC")
				.antMatchers(HttpMethod.GET, "/conclave_planner/**").hasRole("CP")
				.antMatchers(HttpMethod.GET, "/user/**").hasRole("USER").antMatchers(HttpMethod.POST, "/books")
				.hasRole("ADMIN").antMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PATCH, "/books/**").hasRole("ADMIN").antMatchers(HttpMethod.DELETE, "/books/**")
				.hasRole("ADMIN").and().csrf().disable().formLogin().disable();
	}

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}

			@Override
			public boolean matches(CharSequence charSequence, String s) {
				System.out.println(charSequence+" and "+s);
				if (charSequence.equals(s)) {
					return true;
				}
				return false;
			}
		};
	}

}