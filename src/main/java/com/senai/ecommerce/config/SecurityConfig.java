package com.senai.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Autowired
    private SecurityFilter securityFilter;
    
    // 	@Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http.csrf(csrf -> csrf.disable());  // Desliga CSRF 
//         http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());  // Permite TUDO sem login
//         return http.build();
//     }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // cross site request forgery
        return http.csrf(csrf -> csrf.disable())
        // fornece uma sessão sem estado
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()
        .requestMatchers(HttpMethod.POST, "/usuario/atualizar").permitAll()
        .requestMatchers(HttpMethod.POST, "/usuario/deletar").permitAll()
        .requestMatchers(HttpMethod.POST, "/usuario/login").permitAll()
        .requestMatchers(HttpMethod.POST, "/produto/criar").hasRole("ADMIN")
        .requestMatchers(HttpMethod.POST, "/produto/atualizar").hasRole("ADMIN")
        .requestMatchers(HttpMethod.POST, "/produto/deletar").hasRole("ADMIN")
        .anyRequest().authenticated()
        )
        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
        .build();   
    }

}