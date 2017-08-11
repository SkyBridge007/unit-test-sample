/**
 * Project Name:	unit-test-sample
 * File Name:		UserInfoBo.java
 * Package Name:	org.michael.sample.bo
 * Date:			2017年8月9日下午4:05:48
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.bo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月9日 下午4:05:48
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoBO implements Serializable{

	private static final long serialVersionUID = 6648292462483065177L;
	
    private Long userId;
    private String nickname;
    private Integer sex;
    private String mobile;
    private String address;

}

