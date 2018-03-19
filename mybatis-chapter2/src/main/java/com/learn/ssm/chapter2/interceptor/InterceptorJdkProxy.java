package com.learn.ssm.chapter2.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 在JDK动态代理中使用拦截器
 * 
 * @author ahao
 *
 */
public class InterceptorJdkProxy implements InvocationHandler {

	private Object target = null; // 真实对象
	private String interceptorClass = null; // 拦截器全限定名
	
	public InterceptorJdkProxy(Object target, String interceptorClass) {
		this.target = target;
		this.interceptorClass = interceptorClass;
	}
	
	/**
	 * 绑定委托对象并返回一个【代理占位】
	 * 
	 * @param target 真实对象
	 * @param interceptorClass 代理对象【占位】
	 * @return
	 */
	public static Object bind(Object target, String interceptorClass) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), 
				new InterceptorJdkProxy(target, interceptorClass));
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(interceptorClass == null) {
			// 没有设置拦截器则直接反射原有方法
			return method.invoke(target, args);
		}
		Object result = null;
		// 通过反射生成拦截器
		Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
		// 调用前置方法
		if(interceptor.before(proxy, target, method, args)) {
			result = method.invoke(target, args);
		} else {
			interceptor.around(proxy, target, method, args);
		}
		// 调用后置方法
		interceptor.after(proxy, target, method, args);
		return result;
	}

}
