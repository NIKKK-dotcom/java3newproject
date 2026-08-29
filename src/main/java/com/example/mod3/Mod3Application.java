package com.example.mod3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info=@Info(
                title="Product API",
                version= "1.0",
                description ="API для управления продуктами"
        )
)
@SpringBootApplication
public class Mod3Application {
    public static void main(String[] args) {
        SpringApplication.run(Mod3Application.class,args);
    }
}