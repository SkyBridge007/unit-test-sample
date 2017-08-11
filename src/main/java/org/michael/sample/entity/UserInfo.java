/**
 * Project Name:	unit-test-sample
 * File Name:		UserInfo.java
 * Package Name:	org.michael.sample.entity
 * Date:			2017年8月9日下午3:58:09
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月9日 下午3:58:09
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

	private Long id;
	private Long userId;
    private String nickname;
    private Integer sex;
    private String mobile;
    private String address;
    private Date updateTime;
    private Date createTime;

}

