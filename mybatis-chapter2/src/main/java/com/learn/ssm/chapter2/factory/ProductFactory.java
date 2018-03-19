package com.learn.ssm.chapter2.factory;

/**
 * 工厂模式
 * 
 * @author ahao
 *
 */
public class ProductFactory {
	public static IProduct createProduct(String productNo) throws Exception {
		switch(productNo) {
			case "1": return new Product1("product1");
			case "2": return new Product1("product2");
			case "3": return new Product1("product3");
			case "4": return new Product1("product4");
			case "5": return new Product1("product5");
		default: 
			throw new Exception("未支持此编号产品生产");
		}
	}
}
