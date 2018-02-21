package com.learn.ssm.chapter3.demo;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ͨ��XML����SqlSessionFactory
 * @author ahao
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		getSqlSessionFactory();
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			// ����inputstream�����mybatis-config.xml����MyBatis������
			sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return sqlSessionFactory;
	}
}
