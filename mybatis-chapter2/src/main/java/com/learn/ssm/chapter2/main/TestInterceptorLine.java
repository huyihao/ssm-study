package com.learn.ssm.chapter2.main;

import com.learn.ssm.chapter2.interceptor.InterceptorJdkProxy;
import com.learn.ssm.chapter2.proxy.HelloWorld;
import com.learn.ssm.chapter2.proxy.HelloWorldImpl;

/**
 * 测试多层拦截责任链模式
 * 
 * @author ahao
 *
 */
public class TestInterceptorLine {
	public static void main(String[] args) {
		HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), 
								"com.learn.ssm.chapter2.interceptor.Interceptor1");
		HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1, 
								"com.learn.ssm.chapter2.interceptor.Interceptor2");
		HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2, 
				"com.learn.ssm.chapter2.interceptor.Interceptor2");		
		proxy3.sayHelloWorld();
	}
}
