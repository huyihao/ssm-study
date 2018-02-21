package com.learn.ssm.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.learn.ssm.chapter3.mapperInterface.RoleMapper;
import com.learn.ssm.chapter3.pojo.Role;

/**
 * 两种发送SQL的方式
 * @author ahao
 *
 */
public class SendSQL {
	/**
	 * SqlSession直接发送SQL
	 * @param id
	 * @return Role
	 */
	public static Role getRoleBySqlSessionDirectly(Long id) {
		SqlSessionFactory sqlSessionFactory = Demo1.createSqlSessionFactory();
		SqlSession sqlSession = null;
		Role role = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			// 一般写全命名空间，假如能保证SQL id是唯一的，则不加命名空间也可以
			role = (Role)sqlSession.selectOne("com.learn.ssm.chapter3.mapperInterface.RoleMapper.getRole", id);
			sqlSession.commit();  // 提交事务
		} catch (Exception e) {
			sqlSession.rollback();  // 回滚事务
		} finally {
			// 在finally语句中确保资源被顺利关闭
			if(sqlSession != null) {
				sqlSession.close(); 
			}
		}
		return role;
	}
	
	/**
	 * 用Mapper接口发送SQL
	 * @param id
	 * @return Role
	 */
	public static Role getRoleByMapperInterface(Long id) {
		SqlSessionFactory sqlSessionFactory = Demo2.getSqlSessionFactory();
		SqlSession sqlSession = null;
		Role role = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			role = roleMapper.getRole(id);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) {
				sqlSession.close(); 
			}
		}
		return role;
	}
}
