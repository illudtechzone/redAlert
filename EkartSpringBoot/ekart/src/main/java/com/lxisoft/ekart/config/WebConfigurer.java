package com.lxisoft.ekart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfigurer extends  WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedOrigins("http://localhost:4200")
        .allowedMethods("GET","POST" , "PUT" , "DELETE" , "HEAD" , "PATCH" , "OPTIONS")
        .allowedHeaders("*")
        .allowCredentials(true).maxAge(3600);
    }

}