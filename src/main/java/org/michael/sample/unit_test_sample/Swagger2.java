/**
 * Project Name:	unit-test-sample
 * File Name:		Swagger2.java
 * Package Name:	org.michael.sample.unit_test_sample
 * Date:			2017年8月10日下午2:52:47
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.unit_test_sample;

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
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月10日 下午2:52:47
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@Configuration
@EnableSwagger2
public class Swagger2 {
	
	@Bean
    public Docket config() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.michael.sample.manager.web"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Unit-Test-Sample系统API文档")
                .contact(new Contact("作者:Michael", "访问地址", "联系方式"))
                .build();
    }

}

