/**
 * Project Name:	unit-test-sample
 * File Name:		UserInfoManagerController.java
 * Package Name:	org.michael.sample.manager.web
 * Date:			2017年8月10日上午10:28:17
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.manager.web;


import org.michael.sample.bo.UserInfoBO;
import org.michael.sample.manager.UserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月10日 上午10:28:17
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@RestController
@RequestMapping("/userInfo")
@Api(value = "/userInfo", description = "用户信息管理")
public class UserInfoManagerController {
	
	@Autowired
	private UserInfoManager userInfoManager;
	
	@ApiOperation(value="获取用户信息", notes="")
	@GetMapping("/{userId}")
	public Result getUserInfoByUserId(@ApiParam(required = true, value = "用户ID") 
									  @PathVariable Long userId){
		Result result = null;
		UserInfoBO userInfoBO = userInfoManager.getUserInfoByUserId(userId);
		if(userInfoBO != null){
			result = new Result(Result.SUCCESS);
			result.addObject("userInfo", userInfoBO);
		}else{
			result = new Result(Result.FAILURE);
			result.setMsg(result.getMsg().concat(", Found no one by userId: "+userId));
		}
		
		return result;
	}
	
	@ApiOperation(value="新增用户信息", notes="")
	@PostMapping("/add")
	public Result saveUserInfo(@ApiParam(required = true, value = "用户ID") 
									  @RequestBody UserInfoBO userInfoBO){
		Result result = null;
		boolean flag = userInfoManager.saveUserInfo(userInfoBO);
		if(flag){
			result = new Result(Result.SUCCESS);
		}else{
			result = new Result(Result.FAILURE);
			result.setMsg(result.getMsg().concat(", save userInfo failure, Please try again later."));
		}
		
		return result;
	}

}

