/**
 * Project Name:	unit-test-sample
 * File Name:		UserInfoManagerControllerTest.java
 * Package Name:	org.michael.sample.manager.web
 * Date:			2017年8月10日下午5:06:49
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.manager.web;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.michael.sample.bo.UserInfoBO;
import org.michael.sample.manager.UserInfoManager;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;


/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月10日 下午5:06:49
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  //没有使用swagger的话，可以去掉该配置
@ContextConfiguration(locations = {"classpath:test-h2-applicationContext.xml","classpath:test-springmvc-servlet.xml"})
public class UserInfoManagerControllerTest {
	
	@InjectMocks
	@Autowired
	private UserInfoManagerController userInfoManagerController;
	
	@Mock
	private UserInfoManager userInfoManager;
	
    private MockMvc mockMvc;
    
    private UserInfoBO userInfoBO;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(userInfoManagerController).build();
        
        userInfoBO = new UserInfoBO();
        userInfoBO.setUserId(1003L);
        userInfoBO.setNickname("Michael");
        userInfoBO.setSex(1);
        userInfoBO.setMobile("13516553692");
        userInfoBO.setAddress("佛山");
        //用于初始化@Mock注解修饰的组件
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getUserInfoByUserId() throws Exception{
    	
    	when(userInfoManager.getUserInfoByUserId(any(Long.class))).thenReturn(userInfoBO);
   // 	doReturn(userInfoBO).when(userInfoManager).getUserInfoByUserId(any(Long.class));
    	this.mockMvc.perform(MockMvcRequestBuilders.get("/userInfo/1001"))
    				.andDo(print())
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.code", is(0)));
    	
    }
    
    @Test
    public void saveUserInfo() throws Exception{
    	ObjectMapper mapper = new ObjectMapper();
    	when(userInfoManager.saveUserInfo(any(UserInfoBO.class))).thenReturn(true);
   // 	doReturn(true).when(userInfoManager).saveUserInfo(any(UserInfoBO.class));
    	this.mockMvc.perform(post("/userInfo/add")
    				.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(mapper.writeValueAsString(userInfoBO)))
					.andDo(print())
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.code", is(0)));
    	
    }
	

}

