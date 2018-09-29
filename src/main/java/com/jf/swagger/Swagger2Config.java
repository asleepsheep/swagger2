package com.jf.swagger;

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

/**
 * @Description:
 * @Author: jiangfan
 * @CreateTime 2018/9/29 上午10:37
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     *添加摘要信息
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("测试swagger2接口文档")
                        .description("描述：看看到底有多好用")
                        .contact(new Contact("asleepsheep", null, null))
                        .version("版本：1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jf.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
