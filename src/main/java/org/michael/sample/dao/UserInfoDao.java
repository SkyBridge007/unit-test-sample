/**
 * Project Name:	unit-test-sample
 * File Name:		UserInfoDao.java
 * Package Name:	org.michael.sample.dao
 * Date:			2017年8月9日下午4:01:41
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.michael.sample.entity.UserInfo;
import org.springframework.stereotype.Repository;

/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月9日 下午4:01:41
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@Repository
public interface UserInfoDao {
	
    int saveUserInfo(UserInfo userInfo);

    int updateUserInfo(UserInfo userInfo);

    UserInfo getUserInfoByUserId(@Param("userId") Long userId);

    UserInfo getUserInfoByMobile(@Param("mobile") String mobile);

    List<UserInfo> listUserInfoByUserIds(@Param("userIds") List<Long> userIds);

    int removeUserInfoByUserId(@Param("userId") Long userId);

}

