package com.nklcb.cosmos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // swagger test를 위한 설정 (추후 수정 필요)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/swagger.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/schedule/**").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }

}
