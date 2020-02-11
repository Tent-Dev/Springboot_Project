package My.arms.config;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import My.arms.domain.service.MyUserAuthenticationService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)

public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserAuthenticationService userAuthService;
	
	@Autowired
	public void configureUserAuth (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userAuthService);
	}
	
	@Bean
	public String getMd5PasswordEncoder(byte[] code){
		String code_return = MD5Encoder.encode(code);
		return code_return;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/static/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login") //Redirect to login page
			.usernameParameter("email")
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}

}