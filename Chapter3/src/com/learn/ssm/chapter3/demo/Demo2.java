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
 * ͨ�����봴��SqlSessionFactory
 * @author ahao
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		// ���ݿ����ӳ���Ϣ
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ssm");
		dataSource.setDefaultAutoCommit(false);
		
		// ����MyBatis��JDBC����ʽ
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		
		// ����Configuration����
		Configuration configuration = new Configuration(environment);
		
		// ע��һ��MyBatis�����ı���
		configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
		
		// ����һ��ӳ����
		configuration.addMapper(RoleMapper.class);
		
		// ʹ��SqlSessionFactoryBuilder����sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		return sqlSessionFactory;		
	}
}
