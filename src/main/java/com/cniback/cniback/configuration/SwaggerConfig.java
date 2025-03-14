package com.cniback.cniback.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()

				//.apis(RequestHandlerSelectors.any()) //any: documenter toutes les classes dans tous les packages
				.apis(RequestHandlerSelectors.basePackage("com.cniback.cniback")) // basePackage permet de demander à Swagger de ne rien documenter en dehors du package "com.esprit.examen".

				.paths(PathSelectors.any())
				//.paths(PathSelectors.regex("/SpringMVC/client.*")) // accepte seulement les URIs qui commençent par /client. 

				.build().apiInfo(apiInfo());//Informations personnalisées
				//.build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()

				.title("Examen Blanc")
				.description("\"Examen Blanc Swagger configuration\"")

				.version("1.1.0")
				.build();
	}


}