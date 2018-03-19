package com.learn.ssm.chapter2.main;

import com.learn.ssm.chapter2.proxy.HelloWorld;
import com.learn.ssm.chapter2.proxy.HelloWorldImpl;
import com.learn.ssm.chapter2.proxy.JdkProxyExample;

/**
 * 测试 JDK 动态代理
 * 
 * @author ahao
 *
 */
public class TestJdkProxy {
	public static void main(String[] args) {
		JdkProxyExample jdkProxyExample = new JdkProxyExample();
		HelloWorld proxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
		proxy.sayHelloWorld();
	}
}
