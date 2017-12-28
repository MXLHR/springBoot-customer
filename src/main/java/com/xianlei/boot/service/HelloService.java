package com.xianlei.boot.service;

public class HelloService {
	
	private String msg;

	public String getMsg() {
		return this.msg;
	}
	public String sayHello() {
		return "hello" + msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
