package com.example.lab8_gtics.WebSecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable();
        http.httpBasic();
        http.authorizeHttpRequests()
                .requestMatchers("/api/product").authenticated()
                .anyRequest().permitAll();

        return http.build();
    }
}
