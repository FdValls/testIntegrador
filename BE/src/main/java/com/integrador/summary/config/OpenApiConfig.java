package com.integrador.summary.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

        @Bean
        public OpenAPI springShopOpenAPI() {
                return new OpenAPI()
                                .info(new Info().title("Clase 14, aprendiendo swagger :)")
                                                .description("Spring shop sample application")
                                                .version("v0.0.1")
                                                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                                .externalDocs(new ExternalDocumentation()
                                                .description("SpringShop Wiki Documentation")
                                                .url("https://springshop.wiki.github.org/docs"));
        }

}
