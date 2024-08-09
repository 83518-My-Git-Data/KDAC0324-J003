package com.washease.security; // Replace with your actual package name

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//dep : pwd encoder
	@Autowired
	private PasswordEncoder enc;
	//dep : custom jwt auth filter
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	//dep : custom auth entry point
	@Autowired
	private CustomAuthenticationEntryPoint authEntry;
	

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    	http.cors()
//		.and().
//		//disable CSRF token generation n verification
//		csrf()	.disable()
//		.exceptionHandling().authenticationEntryPoint(authEntry).
//		and().
//		authorizeRequests()
//                .antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**", "/user/*","/homepage/*","/address/*").permitAll()
//                .antMatchers(HttpMethod.OPTIONS).permitAll()// Allow access to Swagger UI and registration endpoint
//                .anyRequest().authenticated() // Require authentication for other endpoints
//            .and()
//            .formLogin().permitAll() // Enable form login and permit all to access the login page
//            .and()
//            .logout().permitAll().and()
//    		//inserting jwt filter before sec filter
//    		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//    	; // Allow everyone to access the logout endpoint
//        return http.build();
    	
    	
    	
    	 http.cors()
         .and()
         .csrf().disable()
         .exceptionHandling().authenticationEntryPoint(authEntry)
         .and()
         .authorizeRequests()
             // Permit access to specific endpoints without authentication
             .antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**", "/user/**", "/homepage/**", "/address/**","/selectvendor/**","/vendordashboard/**").permitAll()
             // Allow access to OPTIONS method (useful for CORS preflight requests)
             .antMatchers(HttpMethod.OPTIONS).permitAll()
             // All other endpoints require authentication
             .anyRequest().authenticated()
         .and()
         .formLogin().permitAll()
         .and()
         .logout().permitAll()
         .and()
         .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
     
     return http.build();
    }
    
    @Bean
	public AuthenticationManager authenticationManager
	(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}
}
