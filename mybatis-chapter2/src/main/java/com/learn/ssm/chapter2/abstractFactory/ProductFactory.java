package com.learn.ssm.chapter2.abstractFactory;

import com.learn.ssm.chapter2.factory.IProduct;

/**
 * 抽象工厂模式
 * 
 * @author ahao
 *
 */
public class ProductFactory implements IProductFactory {

	@Override
	public IProduct createProduct(String productNo) {
		char ch = productNo.charAt(0);
		IProductFactory factory = null;
		if(ch == '1') {
			factory = new ProductFactory1();
		} else if(ch == '2') {
			factory = new ProductFactory2();
		} else if(ch == '3') {
			factory = new ProductFactory3();
		}
		if(factory != null) {
			return factory.createProduct(productNo);
		}
		return null;
	}

}
