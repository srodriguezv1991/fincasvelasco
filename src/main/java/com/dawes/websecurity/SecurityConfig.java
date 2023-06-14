package com.dawes.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dawes.services.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	UsuarioService su;

	public String encriptator(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
	}

	@Bean
	public SecurityFilterChain filtrocompleto(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN").and().exceptionHandling()
				.accessDeniedPage("/403");

		http.authorizeHttpRequests().requestMatchers("/","/index", "/finca/homefincas","/variedad/homevariedades", "/tratamiento/hometratamientos", "/recoleccion/homerecolecciones", "/arbol/homearboles", "/finca/mapafinca/**", "/css/**", "/images/**").permitAll().anyRequest().authenticated();

		http.formLogin().loginPage("/login").permitAll();

		http.logout().logoutUrl("/logout").permitAll();

		return http.build();
	}
}
