package com.learn.ssm.chapter2.abstractFactory;

import com.learn.ssm.chapter2.factory.IProduct;

public interface IProductFactory {
	public IProduct createProduct(String productNo);
}
