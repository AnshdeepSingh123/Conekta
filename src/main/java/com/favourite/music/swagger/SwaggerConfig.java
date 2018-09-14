package com.favourite.music.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.favourite.music"))
				.paths(PathSelectors.regex("/users.*"))
				.build()
				.apiInfo(metadata());
	}

	private ApiInfo metadata() {
		
		ApiInfo apiInfo=new ApiInfo("Favourite Music",
				"App Keep Records Of Your Favorite Music",
				"1.0",
				"Terms Of Service",
				new Contact("Anshdeep Singh","","anshdeepsingh290797@gmail.com"),
				"",
				"licence");
		return apiInfo;
	}
}