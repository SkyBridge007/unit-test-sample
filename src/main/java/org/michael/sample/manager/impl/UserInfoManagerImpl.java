/**
 * Project Name:	unit-test-sample
 * File Name:		UserInfoManagerImpl.java
 * Package Name:	org.michael.sample.manager.impl
 * Date:			2017年8月10日上午9:33:33
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.manager.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


import org.michael.sample.bo.UserInfoBO;
import org.michael.sample.dao.UserInfoDao;
import org.michael.sample.entity.UserInfo;
import org.michael.sample.manager.UserInfoManager;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月10日 上午9:33:33
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@Component
@Slf4j
public class UserInfoManagerImpl implements UserInfoManager {
	
	@Resource
	private UserInfoDao userInfoDao;

	@Override
	public Boolean saveUserInfo(UserInfoBO userInfoBO) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userInfoBO.getUserId());
        userInfo.setNickname(userInfoBO.getNickname());
        userInfo.setSex(userInfoBO.getSex());
        userInfo.setMobile(userInfoBO.getMobile());
        userInfo.setAddress(userInfoBO.getAddress());
        userInfo.setUpdateTime(new Date());
        userInfo.setCreateTime(new Date());

        int rows =userInfoDao.saveUserInfo(userInfo);
        if (rows != 1) {
            log.error("save userInfo to db failed. userInfoBO:{}, rows:{}", userInfoBO, rows);
            return false;
        }
        return true;

	}

	@Override
	public Boolean updateUserInfo(UserInfoBO userInfoBO) {
		UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userInfoBO.getUserId());
        userInfo.setMobile(userInfoBO.getMobile());
        userInfo.setNickname(userInfoBO.getNickname());
        userInfo.setSex(userInfoBO.getSex());
        userInfo.setUpdateTime(new Date());
        userInfo.setCreateTime(new Date());

        int rows =userInfoDao.updateUserInfo(userInfo);
        if (rows != 1) {
            log.error("update userInfo to db failed. userInfoBO:{}, rows:{}", userInfoBO, rows);
            return false;
        }
        return true;
	}

	@Override
	public UserInfoBO getUserInfoByUserId(Long userId) {
		UserInfo userInfo = userInfoDao.getUserInfoByUserId(userId);
		UserInfoBO userInfoBO = null;
		if(userInfo != null){
			userInfoBO = new UserInfoBO();
			userInfoBO.setUserId(userInfo.getUserId());
			userInfoBO.setNickname(userInfo.getNickname());
			userInfoBO.setSex(userInfo.getSex());
			userInfoBO.setMobile(userInfo.getMobile());
			userInfoBO.setAddress(userInfo.getAddress());
		}else{
			log.error("find no one by userId. userId:{}", userId);
		}
		return userInfoBO;
	}

	@Override
	public UserInfoBO getUserInfoByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoBO> listUserInfoByUserIds(List<Long> userIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean removeUserInfoByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

