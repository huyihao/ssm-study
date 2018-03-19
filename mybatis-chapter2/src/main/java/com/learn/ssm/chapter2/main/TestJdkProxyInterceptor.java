package com.learn.ssm.chapter2.main;

import com.learn.ssm.chapter2.interceptor.InterceptorJdkProxy;
import com.learn.ssm.chapter2.proxy.HelloWorld;
import com.learn.ssm.chapter2.proxy.HelloWorldImpl;

/**
 * 测试使用 JDK 动态代理的拦截器
 * 
 * @author ahao
 *
 */
public class TestJdkProxyInterceptor {
	public static void main(String[] args) {
		HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), 
									"com.learn.ssm.chapter2.interceptor.MyInterceptor");
		proxy.sayHelloWorld();
	}
}
