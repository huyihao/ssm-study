package com.learn.ssm.chapter2.interceptor;

import java.lang.reflect.Method;

public interface Interceptor {
	/**
	 * 在真实对象前调用
	 * @param proxy
	 * @param target
	 * @param method
	 * @param args
	 * @return true(反射真实对象的方法)|false(调用around方法)
	 */
	public boolean before(Object proxy, Object target, Method method, Object[] args);
	public void around(Object proxy, Object target, Method method, Object[] args);
	public void after(Object proxy, Object target, Method method, Object[] args);
}
