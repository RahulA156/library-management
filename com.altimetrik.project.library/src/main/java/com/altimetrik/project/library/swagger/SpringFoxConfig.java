package com.altimetrik.project.library.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SpringFoxConfig {

	
	
	  @Bean
	 // @Profile("local")
	  public Docket api() { 
		  return new
	  Docket(DocumentationType.SWAGGER_2)
	  .select()
	  .apis(RequestHandlerSelectors.basePackage("com.altimetrik.project.library")).paths(PathSelectors.any()).build();
	  }
	/*  @Bean
	    @Profile("!local")
	    public Docket apiCloud() {

	        return new Docket(DocumentationType.SWAGGER_2)
	                .globalOperationParameters(Collections.singletonList(
	                        new ParameterBuilder()
	                                .name("Authorization")
	                                .modelRef(new ModelRef("string"))
	                                .parameterType("header")
	                                .required(false)
	                                .hidden(true)
	                                .defaultValue("Bearer ")
	                                .build()
	                        )
	                )
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.altimetrik"))
	                .paths(PathSelectors.any())
	                .build();
	    }*/
	    
	    }
	

