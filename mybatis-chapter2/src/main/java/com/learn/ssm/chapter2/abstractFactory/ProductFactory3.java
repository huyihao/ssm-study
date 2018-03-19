package com.learn.ssm.chapter2.abstractFactory;

import com.learn.ssm.chapter2.factory.IProduct;

public class ProductFactory3 implements IProductFactory {

	@Override
	public IProduct createProduct(String productNo) {
		// 工厂3生成产品对象规则，可以是一类产品的规则
		IProduct product = null; 
		return product;
	}

}
