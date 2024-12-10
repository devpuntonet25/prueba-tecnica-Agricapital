package com.hgallgo.prueba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF (opcional para APIs)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v1/**").permitAll() // Permite endpoints públicos
                        .anyRequest().authenticated() // Requiere autenticación para el resto
                );

        return http.build();
    }
}

