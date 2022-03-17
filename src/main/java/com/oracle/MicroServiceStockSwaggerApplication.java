package com.oracle;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableEurekaClient
@EnableSwagger2
public class MicroServiceStockSwaggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceStockSwaggerApplication.class, args);
		System.out.println("In MicroServiceStockSwaggerApplication");
	}
	@Bean
    public Docket swaggerConfiguration()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/**")) // this is for All URIs & sub-URIs
                .apis(RequestHandlerSelectors.basePackage("com.oracle"))
                .build()
                .apiInfo(apiDetails());
    }
    
    private ApiInfo apiDetails()
    {
        return new ApiInfo("Stock REST API", 
                "crud opertions stock", 
                "1.4", 
                "Free APIs",
                new springfox.documentation.service.Contact("Guru", "guru.com", "java.guru@gmail.com"),
                "API license",
                "http://www.guru.com",
                Collections.emptyList()
                );
    }
}