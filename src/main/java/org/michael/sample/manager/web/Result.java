/**
 * Project Name:	unit-test-sample
 * File Name:		Result.java
 * Package Name:	org.michael.sample.manager.web
 * Date:			2017年8月10日下午1:43:02
 * Copyright (c) 2017, hu.wu@meicloud.com All Rights Reserved.
 *
*/
package org.michael.sample.manager.web;

import java.io.Serializable;
import java.util.LinkedHashMap;

/** 
* @author：			Michael
* @version：			1.0
* @createTime：		2017年8月10日 下午1:43:02
* @Email：			hu.wu@meicloud.com
* @Description:		
*/
public class Result implements Serializable{

	private static final long serialVersionUID = 9082050449462904105L;
	
	public final static int SUCCESS = 0;
	
	public final static int FAILURE = 1;
	
	private int code;
	
	private String msg;

	private LinkedHashMap<String, Object> data;
	
	

	public Result() {
		super();
	}

	public Result(int code, String msg, LinkedHashMap<String, Object> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Result(int code) {
		super();
		if(code == SUCCESS){
			this.code = SUCCESS;
			this.msg = "SUCCESS";
		}else{
			this.code = FAILURE;
			this.msg = "FAILURE";
		}
		this.data = new LinkedHashMap<String, Object>();
	}
	


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LinkedHashMap<String, Object> getData() {
		return data;
	}

	public void setData(LinkedHashMap<String, Object> data) {
		this.data = data;
	}

	public void addObject(String key,Object value){
		getData().put(key, value);
	}

}

