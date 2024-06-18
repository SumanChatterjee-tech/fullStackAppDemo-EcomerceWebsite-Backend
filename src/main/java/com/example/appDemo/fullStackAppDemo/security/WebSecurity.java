package com.example.appDemo.fullStackAppDemo.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.appDemo.fullStackAppDemo.service.userService;
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	private userService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(com.example.appDemo.fullStackAppDemo.service.userService userService,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
				.antMatchers(HttpMethod.GET,SecurityConstants.EMAIL_VERIFICATION_URL).permitAll()
				.antMatchers(HttpMethod.POST, SecurityConstants.EMAIL_FEEDBACK_URL).permitAll()
				.antMatchers(HttpMethod.GET, SecurityConstants.SHOW_FEEDBACKS_URL).permitAll()
				.antMatchers(HttpMethod.GET, SecurityConstants.FORGOT_PASSWORD_URL).permitAll()
				.antMatchers(HttpMethod.POST, SecurityConstants.CHANGE_PASSWORD_URL).permitAll()
				.anyRequest().authenticated()
				.and().addFilter(getAuthenticationFilter())
				.addFilter(new AuthorizationFilter(authenticationManager()))
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	protected AuthenticationFilter getAuthenticationFilter() throws Exception {
		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		System.out.println("Hello");
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://sumanshop-demo-application.s3-website.ap-south-1.amazonaws.com"));
		configuration.setAllowedMethods(Arrays.asList("PUT","POST","GET","OPTIONS","PATCH","DELETE"));
		configuration.setAllowCredentials(true); // *
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setExposedHeaders(Arrays.asList("*"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;

	}
}
