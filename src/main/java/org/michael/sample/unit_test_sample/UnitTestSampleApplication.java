/**
 * Project Name:	unit-test-sample
 * File Name:		UnitTestSampleApplication.java
 * Package Name:	org.michael.sample.unit_test_sample
 * Date:			2017年8月9日下午2:54:30
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.unit_test_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月9日 下午2:54:30
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@SpringBootApplication
@ImportResource(value = "classpath:spring-applicationContext.xml")
public class UnitTestSampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UnitTestSampleApplication.class,args);
	}

}

