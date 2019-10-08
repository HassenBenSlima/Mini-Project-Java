package ord.syscomputer;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)//POUR LES annotation @secured
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception{
		/*auth.inMemoryAuthentication()//les utilisateur se trouve au memoire//on peut sepecifié quelle type d'authentification est ce que les utilisateur dans la base de données
		.withUser("admin").password("123").roles("ADMIN","PROF");
		auth.inMemoryAuthentication()
		.withUser("prof1").password("123").roles("PROF");
		auth.inMemoryAuthentication()
		.withUser("et1").password("123").roles("ETUDIANT");

		auth.inMemoryAuthentication()
		.withUser("sco1").password("123").roles("SCOLARITE");
*/
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username as principal,password as credentials, true from users where username= ?")
		.authoritiesByUsernameQuery("select user_username as principal,roles_role as role  from users_roles where user_username= ? ")
		.rolePrefix("ROLE_");
		
		
	}
	
	@Override//on va mettre les regle de securité dans cette methode
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()//desactiver le jeton
		.antMatchers("/css/**","/js/**","/images/**").permitAll()				//authorisation file ressource
		.anyRequest()
					.authenticated()//toutes les requette doit etre authentifié
	//configuration de base 
						.and()//ajouter une nouvelle regle
							.formLogin()
								.loginPage("/login")
								.permitAll()
								.defaultSuccessUrl("/index.html")//autorisation d'accees
								.and()
							.logout()
								.invalidateHttpSession(true)
								.logoutUrl("/logout")
								.permitAll();
		/*.and()
	      .exceptionHandling().accessDeniedPage("/403.html");*/
	}
}
