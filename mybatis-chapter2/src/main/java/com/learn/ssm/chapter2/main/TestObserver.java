package com.learn.ssm.chapter2.main;

import com.learn.ssm.chapter2.observer.JingDongObserver;
import com.learn.ssm.chapter2.observer.ProductList;
import com.learn.ssm.chapter2.observer.TaobaoObserver;

/**
 * 测试观察者模式
 * 
 * @author ahao
 *
 */
public class TestObserver {      
	public static void main(String[] args) {
		ProductList observable = ProductList.getInstance();
		TaobaoObserver taobaoObserver = new TaobaoObserver();
		JingDongObserver jingDongObserver = new JingDongObserver();
		observable.addObserver(jingDongObserver);
		observable.addObserver(taobaoObserver);
		observable.addProduct("产品1");               
	}
}
                                       