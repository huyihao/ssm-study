package com.learn.ssm.chapter2.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.learn.ssm.chapter2.reflect.ReflectServiceImpl;
import com.learn.ssm.chapter2.reflect.ReflectServiceImpl2;

/**
 * 测试反射对象和反射方法调用
 * 
 * @author ahao
 *
 */
public class TestReflectServiceImpl {
	public static void main(String[] args) {
		TestReflectServiceImpl testCase = new TestReflectServiceImpl();
		
		ReflectServiceImpl reflectServiceImpl1 = testCase.getInstance();
		reflectServiceImpl1.sayHello("Kurry");
		
		ReflectServiceImpl2 reflectServiceImpl2 = testCase.getInstance2();
		reflectServiceImpl2.sayHello();
		
		testCase.reflectMethod();
		
		testCase.reflectMethod2();
		
		testCase.reflect();
	}
	
	/**
	 * ==========================================
	 * 
	 *              一、使用反射生成对象
	 * 
	 * ==========================================
	 */
	
	/**
	 * 1、使用反射生成不带参构造的对象 
	 * @return
	 */
	public ReflectServiceImpl getInstance() {
		ReflectServiceImpl object = null;
		try {
			object = (ReflectServiceImpl) 
					Class.forName("com.learn.ssm.chapter4.reflect.ReflectServiceImpl").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			ex.printStackTrace();
		}
		return object;
	}
	
	/**
	 * 2、使用反射生成带参构造的对象
	 * @return
	 */
	public ReflectServiceImpl2 getInstance2() {
		ReflectServiceImpl2 object = null;
		try {
			object = (ReflectServiceImpl2) Class.forName("com.learn.ssm.chapter4.reflect.ReflectServiceImpl2")
												.getConstructor(String.class).newInstance("胡奕豪");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | 
				 InvocationTargetException | NoSuchMethodException | SecurityException | 
				 ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return object;
	}
	
	/**
	 * ============================================
	 * 
	 *                 二、反射方法
	 * 
	 * ============================================
	 */
	/**
	 * 3、使用带参反射方法
	 * @return
	 */
	public Object reflectMethod() {
		Object returnObj = null;
		ReflectServiceImpl target = new ReflectServiceImpl();
		try {
			Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
			returnObj = method.invoke(target, "张三");			
		} catch (NoSuchMethodException | SecurityException |
				 IllegalAccessException | IllegalArgumentException |
				 InvocationTargetException ex) {
			ex.printStackTrace();
		}
		return returnObj;
	}
	
	/**
	 * 4、使用不带参的反射方法
	 * @return
	 */
	public Object reflectMethod2() {
		Object returnObj = null;
		ReflectServiceImpl target = new ReflectServiceImpl();
		try {
			Method method = ReflectServiceImpl.class.getMethod("helloWorld");
			returnObj = method.invoke(target);
		} catch (NoSuchMethodException | SecurityException |
				 IllegalAccessException | IllegalArgumentException |
				 InvocationTargetException ex) {
			ex.printStackTrace();
		}
		return returnObj;
	}
	
	/**
	 * ============================================
	 * 
	 *     三、使用反射生成对象，使用反射对象获取反射方法并调度
	 * 
	 * ============================================
	 */
	public Object reflect() {
		ReflectServiceImpl object = null;
		try {
			object = (ReflectServiceImpl) 
						Class.forName("com.learn.ssm.chapter4.reflect.ReflectServiceImpl").newInstance();
			Method method = object.getClass().getMethod("sayHello", String.class);
			method.invoke(object, "王五");
		} catch (NoSuchMethodException | SecurityException |
				 IllegalAccessException | IllegalArgumentException |
				 InvocationTargetException | InstantiationException |
				 ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return object;
	}
}
