package com.spring.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration	// 스프링 실행시 설정파일 읽어드리기 위한 어노테이션 
public class SwaggerConfig {

    private static final String API_TITLE = "GLotto API";
    private static final String API_VERSION = "1.0.0";
    private static final String API_DESCRIPTION = "GLotto API 명세서";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .version(API_VERSION)
                .termsOfServiceUrl("서비스 약관 url")
                .license("MIT")
                .licenseUrl("http://license.com")
                .description(API_DESCRIPTION)
                .build();
    }

    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.OAS_30)
            .useDefaultResponseMessages(false) // Swagger 에서 제공해주는 기본 응답 코드 (200, 401, 403, 404). false 로 설정하면 기본 응답 코드를 노출하지 않음
            .select()
            //.apis(RequestHandlerSelectors.any())    // 모든 RequestMapping URI 추출
            .apis(RequestHandlerSelectors.basePackage("com.spring.domain"))    // api 스펙이 작성되어 있는 패키지 (Controller) 를 지정, // Controller에서 RequestMapping 추출            
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.apiInfo());
    }
}
