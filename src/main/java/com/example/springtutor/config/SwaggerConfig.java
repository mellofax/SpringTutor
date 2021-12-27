package com.example.springtutor.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("My OpenAPI Documentation")
                                .version("9.9.9")
                                .contact(
                                        new Contact()
                                                .email("barmansuperman@gmail.com")
                                                .url("https://vk.com/blueberry_for_you")
                                                .name("Nikita Belko")
                                )
                );
    }
}
