package com.getnet.UserGetNet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


//Configuração para SwaggerUI - Documentação
@Configuration
@EnableWebMvc
public class SpringFoxConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api Users GetNet")
                .description("Desafio técnico para processo seletivo da GetNet \n - Criação de uma nova Api, considerando criação, alteração e consulta de usuários.  \n\nRequisições: \nCriação de Usuário \n  - Input: nome, password e email   \n\nConsulta de Usuário  \n   - Input: identificador único \n - Output: nome, password e email   \n\nListagem de Usuários\n   - Output: nome, password e email   \n\nAlteração de Usuário  \n   - Input: nome, password e email \n  - Output: nome, password e email ")
                .version("1.0.0")
                .contact(new Contact("Giovani Silva","http://Github.com/giovanispaula", "giovannispaula@gmail.com"))
                .build();
    }

}
