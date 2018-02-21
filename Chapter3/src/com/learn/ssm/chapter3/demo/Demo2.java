package com.learn.ssm.chapter3.demo;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.pojo.Role;

/**
 * 通过代码创建SqlSessionFactory
 * @author ahao
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		// 数据库连接池信息
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ssm");
		dataSource.setDefaultAutoCommit(false);
		
		// 采用MyBatis的JDBC事务方式
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		
		// 创建Configuration对象
		Configuration configuration = new Configuration(environment);
		
		// 注册一个MyBatis上下文别名
		configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
		
		// 加入一个映射器
		configuration.addMapper(RoleMapper.class);
		
		// 使用SqlSessionFactoryBuilder构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		return sqlSessionFactory;		
	}
}
