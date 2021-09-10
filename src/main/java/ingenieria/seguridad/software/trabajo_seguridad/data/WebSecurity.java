package ingenieria.seguridad.software.trabajo_seguridad.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("root").password("linux").roles("USER", "ADMIN").and()
		//	.withUser("test").password("test123").roles("USER");
		auth.inMemoryAuthentication().withUser("root").password("{noop}linux").roles("USER", "ADMIN").and()
			.withUser("test").password("{noop}test123").roles("USER");
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/api/Estudiante/**").hasRole("USER")
			.antMatchers(HttpMethod.POST, "/api/Estudiante/").hasRole("USER")
			.antMatchers(HttpMethod.POST, "/api/Estudiante").hasRole("USER")
			.antMatchers(HttpMethod.PUT, "/api/Estudiante/**").hasRole("USER")
			.antMatchers(HttpMethod.DELETE, "/api/Estudiante/**").hasRole("USER")
			.antMatchers("/api/Matricula/**").hasRole("USER")
			.antMatchers("/api/Inscripcion/**").hasRole("USER")
			.and().csrf().disable().formLogin().disable();
		super.configure(http);
	}
}
