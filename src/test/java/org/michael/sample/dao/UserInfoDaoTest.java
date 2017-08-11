/**
 * Project Name:	unit-test-sample
 * File Name:		UserInfoDaoTest.java
 * Package Name:	org.michael.sample.dao
 * Date:			2017年8月9日下午7:03:02
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.michael.sample.entity.UserInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月9日 下午7:03:02
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //没有使用swagger的话，可以去掉该配置
@ContextConfiguration("classpath:test-h2-applicationContext.xml")
public class UserInfoDaoTest {
	
	@Resource
	private UserInfoDao userInfoDao;
	
    @Test
    public void saveUserInfo() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1003L);
        userInfo.setNickname("wangwu");
        userInfo.setMobile("18890987675");
        userInfo.setSex(1);
        userInfo.setUpdateTime(new Date());
        userInfo.setCreateTime(new Date());

        int rows = userInfoDao.saveUserInfo(userInfo);

        assertEquals(1, rows);
    }
    
    @Test
    public void updateUserInfo() throws Exception{
    	UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1001L);
        userInfo.setNickname("MichaelWu");
        userInfo.setMobile("18890987675");
        userInfo.setSex(1);
        userInfo.setUpdateTime(new Date());
        userInfo.setCreateTime(new Date());
        
        int rows = userInfoDao.updateUserInfo(userInfo);
        
        assertEquals(1, rows);
    }
    
    @Test
    public void getUserInfoByUserId() throws Exception {
    	UserInfo userInfo = userInfoDao.getUserInfoByUserId(1002L);
    	assertEquals("lisi", userInfo.getNickname());
    }
    
    @Test
    public void getUserInfoByMobile() throws Exception{
    	UserInfo userInfo = userInfoDao.getUserInfoByMobile("15906690704");
    	assertEquals("深圳", userInfo.getAddress());
    }
    
    @Test
    public void removeUserInfoByUserId() throws Exception{
    	int rows = userInfoDao.removeUserInfoByUserId(1002L);	
    	assertEquals(1, rows);
    }
    
    @Test
    public void listUserInfoByUserIds() throws Exception{
    	List<Long> userIds = new ArrayList<>();
    	userIds.add(1002L);
    	userIds.add(1001L);
    	List<UserInfo> userInfos = userInfoDao.listUserInfoByUserIds(userIds);
  //  	assertEquals(2, userInfos.size());
    	assert(userInfos.size()>0);
    }

}

