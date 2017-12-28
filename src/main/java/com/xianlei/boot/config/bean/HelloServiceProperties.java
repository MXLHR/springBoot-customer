package com.xianlei.boot.config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 这里配饰是类型安全的属性获取
 * 
 * 在application.properties中通过hello.msg来设置
 * 
 * @author Xianlei
 *
 */
@ConfigurationProperties("hello")
public class HelloServiceProperties {

	private static final String MSG = "world";
	
	private String msg = MSG;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
