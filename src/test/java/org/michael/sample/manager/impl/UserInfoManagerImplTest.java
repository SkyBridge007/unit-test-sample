/**
 * Project Name:	unit-test-sample
 * File Name:		UserInfoManagerImplTest.java
 * Package Name:	org.michael.sample.manager.impl
 * Date:			2017年8月10日上午9:49:16
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.manager.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.michael.sample.bo.UserInfoBO;
import org.michael.sample.dao.UserInfoDao;
import org.michael.sample.entity.UserInfo;
import org.michael.sample.manager.UserInfoManager;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月10日 上午9:49:16
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@RunWith(MockitoJUnitRunner.class)
public class UserInfoManagerImplTest {
	
	@Mock //用于定义被Mock的组件
	private UserInfoDao userInfoDao;
	
	@InjectMocks //用于定义待测试的组件
	private UserInfoManager userInfoManager = new UserInfoManagerImpl();
	
	private UserInfo userInfo;
	
	private UserInfoBO userInfoBO;
	
	@Before
    public void setUp() throws Exception {
        //用于初始化@Mock注解修饰的组件
        MockitoAnnotations.initMocks(this);
        
        userInfoBO = new UserInfoBO();
        userInfoBO.setUserId(1003L);
        userInfoBO.setNickname("Michael");
        userInfoBO.setSex(1);
        userInfoBO.setMobile("13516553692");
        userInfoBO.setAddress("佛山");
        
        userInfo = new UserInfo();
        userInfo.setId(1000001L);
        userInfo.setUserId(1003L);
        userInfo.setNickname("Michael");
        userInfo.setSex(1);
        userInfo.setMobile("13516553692");
        userInfo.setAddress("北京");
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        
	
	}
	
	@Test
	public void saveUserInfo_case1() throws Exception{
		//step1 打桩    准备数据和动作
		doReturn(1).when(userInfoDao).saveUserInfo(any(UserInfo.class));
		
		//step2 运行待测试模块
		Boolean result = userInfoManager.saveUserInfo(userInfoBO);
		
		//step3 验证测试结果
        assertTrue(result);
	}
	
	@Test
	public void saveUserInfo_case2() throws Exception{
		//step1 打桩    准备数据和动作
		doReturn(0).when(userInfoDao).saveUserInfo(any(UserInfo.class));
		
		//step2 运行待测试模块
		Boolean result = userInfoManager.saveUserInfo(userInfoBO);
		
		//step3 验证测试结果
        assertFalse(result);
	}
	
	@Test
	public void getUserInfoByUserId() throws Exception{
		//step1 打桩    准备数据和动作
		doReturn(userInfo).when(userInfoDao).getUserInfoByUserId(any(Long.class));
		
		//step2 运行待测试模块		
		userInfoBO = userInfoManager.getUserInfoByUserId(10001L);
		
		//step3 验证测试结果
		assertEquals("北京", userInfoBO.getAddress());
	}
}

