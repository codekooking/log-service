package com.codekooking.logservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.codekooking.logservice.controllers"))
                .paths(regex("/example.*"))
                .build()
                .apiInfo(apiInfo());
    }
	
	private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "Log Service REST API", 
	       "This is REST API used to store Application log messages to RabbitMQ", 
	       "API TOS", 
	       "Terms of service", 
	       new Contact("Code Kooking", "http://www.codekooking.com", "thuannguyenit@gmail.com"), 
	       "Apache License 2.0", "http://www.apache.org/licenses", Collections.emptyList());
	}
}
