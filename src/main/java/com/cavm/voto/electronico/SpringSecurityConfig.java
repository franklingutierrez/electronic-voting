package com.cavm.voto.electronico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.cavm.voto.electronico.services.UserServiceImpl;

@Configuration
//@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfig {
	
	@Autowired
	private UserServiceImpl userDetail;
	
	@Bean
	public UserDetailsService userDetailsService()throws Exception{
				
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User
	            .withUsername("user")
	            .password(passwordEncoder().encode("user"))
	            .roles("USER")
	            .build());
		 manager.createUser(User
		            .withUsername("admin")
		            .password(passwordEncoder().encode("admin"))
		            .roles("ADMIN","USER")
		            .build());
		
		return manager;
		/*UserDetails user =
				 User.withDefaultPasswordEncoder()
					.username("user")
					.password("password")
					.roles("USER")
					.build();

			return new InMemoryUserDetailsManager(user);*/

	}
	
	@Bean 
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
		return new MvcRequestMatcher.Builder(introspector);
	}

	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
		http
		.authorizeHttpRequests((requests) -> requests
			.requestMatchers(mvc.pattern("/"),mvc.pattern("/login"), mvc.pattern("/election/**"),mvc.pattern("/img/**"),mvc.pattern("/css/**"),mvc.pattern("/js/**"),mvc.pattern("/uploads/**")).permitAll()
			//.requestMatchers("/institution").hasRole("ADMIN")
			.anyRequest().authenticated()
		)
		.formLogin((form) -> form
			.loginPage("/login")
			.permitAll()
		)
		.logout((logout) -> logout.permitAll())
		.exceptionHandling((error)->{
			error.accessDeniedPage("/error_403");
		});

	return http.build();
		
		
            
    }
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(userDetail)
		.passwordEncoder(passwordEncoder());

	}
    
}
