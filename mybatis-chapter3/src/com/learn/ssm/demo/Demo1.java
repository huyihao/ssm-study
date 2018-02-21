package com.learn.ssm.demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 3.4.1 通过XML构建SqlSessionFactory
 * @author ahao
 *
 */
public class Demo1 {
	private static String resource = "mybatis-config.xml";

	public static SqlSessionFactory createSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return sqlSessionFactory;
	}
}
