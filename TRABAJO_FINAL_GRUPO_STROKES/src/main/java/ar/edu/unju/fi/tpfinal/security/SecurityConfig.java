package ar.edu.unju.fi.tpfinal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsServiceImp userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/auth/**", "/public/**", "/image/**", "/css/**", "/webjars/**").permitAll()
		.antMatchers("/productline/editar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/productline/seleccionar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/productline/borrar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/empleado/nuevo").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/empleado/editar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/empleado/seleccionar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/empleado/borrar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/oficina/nueva").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/oficina/editar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/oficina/seleccionar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/oficina/borrar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/compra/editar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/compra/seleccionar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/compra/borrar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/detalle/editar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/detalle/seleccionar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/detalle/borrar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/pago/editar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/pago/seleccionar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/pago/borrar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/producto/seleccionar/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/producto/borrar/**").hasAnyAuthority("ROLE_ADMIN")
		.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/auth/login").defaultSuccessUrl("/private/index", true).failureUrl("/auth/login?error=true")
			.loginProcessingUrl("/auth/login-post").permitAll()
		.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/public/index");
	}
	
}
