package com.example.car_management;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        // Configure CORS for all paths
        corsRegistry.addMapping("/**")
                // Allow frontend to access backend from localhost
                .allowedOrigins("http://localhost:3000")
                // Allow the following HTTP methods
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // Allow all headers
                .allowedHeaders("*")
                // Allow sending cookies and authentication credentials
                .allowCredentials(true);
    }
}
