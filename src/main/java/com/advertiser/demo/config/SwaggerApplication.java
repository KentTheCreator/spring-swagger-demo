package com.advertiser.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is all that is required to expose useful
 * REST implementation in basePackage through Swagger UI
 * http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerApplication {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.advertiser.demo"))
				.build()
				.apiInfo(customMetaData());
	}

	// Adds some customization to the page
	private ApiInfo customMetaData() {
		return new ApiInfoBuilder()
				.title("Advertiser API demo")
				.description("\"Spring Boot REST API for Advertiser\"")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.contact(new Contact("Kent Lybrook",
						"https://github.com/KentTheCreator/spring-swagger-demo",
						"kent.lybrook@gmail.com"))
				.build();
	}
}
