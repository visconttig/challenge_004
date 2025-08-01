package com.viscontti.hub.foro.foro_hub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // allow all requests without auth
                )
                .httpBasic(httpBasic -> httpBasic.disable()) // disable HTTP Basic auth
                .formLogin(form -> form.disable()); // disable login form

        return http.build();
    }
}
