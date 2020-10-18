package com.interestedmandrake.restservice.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			  "Api Documentation",
		      "Api Documentation",
		      "1.0",
		      "urn:tos",
		      new Contact("interested-mandrake", "", "someEmail@email.com"),
		      "Apache 2.0",
		      "http://www.apache.org/licenses/LICEENSE-2.0",
		      new ArrayList<VendorExtension>());

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}
}
