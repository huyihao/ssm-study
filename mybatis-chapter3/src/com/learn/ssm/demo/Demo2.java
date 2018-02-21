package com.learn.ssm.demo;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.learn.ssm.chapter3.pojo.Role;

/**
 * 3.4.2 ʹ�ô��봴��SqlSessionFactorys
 * @author ahao
 *
 */
public class Demo2 {
	public static SqlSessionFactory getSqlSessionFactory() {
		// ���ݿ����ӳ���Ϣ
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.sql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setUrl("jdbc:mysql://localhost:3306/chapter3");
		
		// ����MyBatis��JDBC����ʽ
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		
		// ����Configuration����
		Configuration configuration = new Configuration(environment);
		
		// ע��һ��MyBatis�����ı���
		configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
		
		// ʹ��SqlSessionFactoryBuilder����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		return sqlSessionFactory;
	}
}
