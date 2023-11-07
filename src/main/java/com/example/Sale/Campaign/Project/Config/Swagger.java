package com.example.Sale.Campaign.Project.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

        @Bean
        OpenAPI customOpenApi() {
            return new OpenAPI().info(
                    new Info()
                            .title("Demo for Implement Swagger")
                            .version("v1")
                            .description("Hello guys, chalo khane")
                            .termsOfService("https://springdoc.org/")
                            .license(
                                    new License()
                                            .name("OpenSource")
                                            .url("https://springdoc.org/")
                            )
            );
        }

}
