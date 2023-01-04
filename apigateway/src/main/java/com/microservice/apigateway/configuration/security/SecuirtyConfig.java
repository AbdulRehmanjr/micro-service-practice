package com.microservice.apigateway.configuration.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


// make a class usng spring secuirty 6.0.1 and make some methods of secuirty
@Configuration
@EnableWebSecurity
public class SecuirtyConfig {
    
    public void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .cors()
        .and()
        .authorizeHttpRequests()
        .requestMatchers("/**").permitAll()
        .anyRequest().authenticated();
        http.build();
        
    }
}    

        
               

 