package com.bbletscode.rotativo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springSwaggerOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Controle Rotativo")
                .description("Lets Code - Banco do Brasil")
                .version("v0.0.1"));
    }
}
