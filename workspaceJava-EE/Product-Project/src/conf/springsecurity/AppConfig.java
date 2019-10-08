package conf.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder =passwordEncoder();
		auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("hassen").password(encoder.encode("123")).authorities("ROLE_USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").authenticated().anyRequest().authenticated();
		http.formLogin().loginPage("/login").defaultSuccessUrl("/index").permitAll();
		
		
		// http.authorizeRequests().antMatchers("/Saisie.php").hasRole("USER");

		// http.httpBasic();

		// http.authorizeRequests().antMatchers("/Saisie.php").hasRole("USER");
		// http.authorizeRequests().antMatchers("/index.php",
		// "/Saisie.jsp").hasRole("USER");
	
//		 http.csrf().disable()
//         .authorizeRequests()
//				
//				
//				.antMatchers("/index/**").hasAnyRole("USER")
//				.anyRequest().authenticated()
//         .and()
//         .formLogin()
//				.loginPage("/login").defaultSuccessUrl("/index")
//				.permitAll()
//				.and()
//         .logout()
//				.permitAll()
//			;

	}

}