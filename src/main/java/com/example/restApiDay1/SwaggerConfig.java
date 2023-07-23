package com.example.restApiDay1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  
//Enable Swagger  
@EnableSwagger2
public class SwaggerConfig {

  


//creating bean  
    
@Bean  
public Docket api()  
{  
//creating constructor of Docket class that accepts parameter DocumentationType  
return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors
		.basePackage("com.example.restApiDay1"))
		.paths(PathSelectors.regex(("/.*")))
		.build().apiInfo(apiEndPointsInfo());  


} 
private ApiInfo apiEndPointsInfo() {

    return new ApiInfoBuilder().title("Rabin Software For Infosec Risk, Compliance & Audit Management")
        .description("Rabin Software For Infosec Risk, Compliance & Audit Management")
        .contact(new Contact("rabins", "https://www.rabins.com/", "rabins@gmail.com"))
        .license("Apache 2.0")
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
        .version("1.0.0")
        .build();
}
}  


