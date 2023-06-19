package com.apm.API;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite todos los endpoints de la API
                .allowedOrigins("*") // Permite todos los orígenes
                .allowedMethods("*") // Permite todos los métodos HTTP (GET, POST, PUT, etc.)
                .allowedHeaders("*"); // Permite todas las cabeceras
    }
}
