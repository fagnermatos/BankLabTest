package io.labsit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket greetingApi() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(basePackage("io.labsit"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo());

    }

    private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .title("Labsit Conta Corrente REST API")
                .description("REST API para gerenciar conta corrente")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Fagner Matos",
                        "linkedin.com/in/fagner-matos",
                        "fagnerjmatosifce@gmail.com"))
                .build();
    }
}
