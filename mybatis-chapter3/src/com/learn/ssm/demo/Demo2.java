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
 * 3.4.2 使用代码创建SqlSessionFactorys
 * @author ahao
 *
 */
public class Demo2 {
	public static SqlSessionFactory getSqlSessionFactory() {
		// 数据库连接池信息
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.sql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setUrl("jdbc:mysql://localhost:3306/chapter3");
		
		// 采用MyBatis的JDBC事务方式
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		
		// 创建Configuration对象
		Configuration configuration = new Configuration(environment);
		
		// 注册一个MyBatis上下文别名
		configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
		
		// 使用SqlSessionFactoryBuilder构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		return sqlSessionFactory;
	}
}
