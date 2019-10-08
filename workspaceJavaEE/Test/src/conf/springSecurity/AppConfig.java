package conf.springSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("hassen").password("123").roles("USER");
		auth.inMemoryAuthentication().withUser("atef").password("123").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests().antMatchers("/*").permitAll().anyRequest().authenticated();
		http.formLogin().loginPage("/login").defaultSuccessUrl("/zdz").permitAll();
		http.httpBasic();

		// http.authorizeRequests().antMatchers("/Saisie.php").hasRole("USER");
		// http.authorizeRequests().antMatchers("/index.php",
		// "/Saisie.jsp").hasRole("USER");

	}

}