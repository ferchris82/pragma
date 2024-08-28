package com.chrisferdev.pragma.infrastructure.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// http://localhost:8084/swagger-ui/index.html

@Configuration
public class OpenApiDocumentation {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Categorías")
                        .version("1.0")
                        .description("Documentación de la API para gestionar categorías"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("categorias")
                .pathsToMatch("/api/categories/**")
                .build();
    }
}
