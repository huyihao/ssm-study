package com.learn.ssm.chapter2.main;

import com.learn.ssm.chapter2.proxy.CglibProxyExample;
import com.learn.ssm.chapter2.reflect.ReflectServiceImpl;

/**
 * 测试 CGLIB 动态代理 
 * 
 * @author ahao
 *
 */
public class TestCglibProxy {
	public static void main(String[] args) {
		CglibProxyExample cglibProxyExample = new CglibProxyExample();
		ReflectServiceImpl reflectServiceImpl = (ReflectServiceImpl) cglibProxyExample.getProxy(ReflectServiceImpl.class);
		reflectServiceImpl.sayHello("周六");
	}
}
