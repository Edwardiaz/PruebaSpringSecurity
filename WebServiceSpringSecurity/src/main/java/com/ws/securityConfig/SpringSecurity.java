package com.ws.securityConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackages = "com.ws.dao")
@EnableTransactionManagement
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	

	@Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
	

//	@Qualifier("DATA")
//	@Autowired
//	private DataSource dataSource;
	
//	@Autowired
//	public SpringSecurity(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	 
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) 
//	  throws Exception {
//		
//	    auth.jdbcAuthentication().dataSource(dataSource)
//	      .withDefaultSchema()
//	      .withUser("user").password("password").roles("USER")
//	      .and()
//	      .withUser("admin").password("password").roles("USER", "ADMIN");
//	}
	
//	protected void configure(HttpSecurity http) throws Exception {
//	    http.authorizeRequests()
//	      .anyRequest().authenticated()
//	      .and().httpBasic();
//	}
	
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	      .anyRequest().authenticated()
	      .and().formLogin()
	      .loginPage("/login").permitAll();
	}

//	protected void configure(HttpSecurity http) throws Exception {
//	    http.authorizeRequests()
//	      .antMatchers("/", "/home").access("hasRole('USER')")
//	      .antMatchers("/admin/**").hasRole("ADMIN")
//	      .and()
//	      // some more method calls
//	      .formLogin();
//	}
	
	//a complete logaout implementation... from an old version of spring security core...
//	protected void configure(HttpSecurity http) throws Exception {
//	    http.logout().logoutUrl("/my/logout")
//	      .logoutSuccessUrl("/my/index")
//	      .logoutSuccessHandler(logoutSuccessHandler) 
//	      .invalidateHttpSession(true)
//	      .addLogoutHandler(logoutHandler)
//	      .deleteCookies(cookieNamesToClear)
//	      .and()
//	      // some other method calls
//	}
	
	//some test purpose!
//	protected void configure(HttpSecurity http) throws Exception {
//	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
//	    .and().antMatcher("/api/products").authorizeRequests().and().("hasRole('USER')")
//	      .antMatchers("/api/role").hasRole("ADMIN")
//	      .and()
//	      // some more method calls
//	      .formLogin();
//	}
	
	
}
