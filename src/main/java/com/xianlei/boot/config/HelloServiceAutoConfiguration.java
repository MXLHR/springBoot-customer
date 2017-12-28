package com.xianlei.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xianlei.boot.config.bean.HelloServiceProperties;
import com.xianlei.boot.service.HelloService;

//自动配置类
@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix="hello",value="enabled",matchIfMissing=true)
public class HelloServiceAutoConfiguration {
	
	@Autowired
	private HelloServiceProperties helloServiceProperties;
	
	@Bean
	@ConditionalOnMissingBean(HelloService.class)
	public HelloService helloService(){
		HelloService helloService = new HelloService();
		helloService.setMsg(helloServiceProperties.getMsg());
		return helloService;
	}
	
	/*
	 * 注释： 根据HelloServiceProperties提供的参数，并通过@ConditionalOnClass判断
	 * HelloService这个类在类路径是否存在，且当容器中没有这个Bean的情况下自动配置这个Bean
	 */
	/*
	 *5.注册配置。
	 *若想配置生效，需要注册自动配置类。 新建 /META-INF/spring.factories 
	 */

}
