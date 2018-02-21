package com.learn.ssm.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.learn.ssm.chapter3.mapperInterface.RoleMapper;
import com.learn.ssm.chapter3.pojo.Role;

/**
 * ���ַ���SQL�ķ�ʽ
 * @author ahao
 *
 */
public class SendSQL {
	/**
	 * SqlSessionֱ�ӷ���SQL
	 * @param id
	 * @return Role
	 */
	public static Role getRoleBySqlSessionDirectly(Long id) {
		SqlSessionFactory sqlSessionFactory = Demo1.createSqlSessionFactory();
		SqlSession sqlSession = null;
		Role role = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			// һ��дȫ�����ռ䣬�����ܱ�֤SQL id��Ψһ�ģ��򲻼������ռ�Ҳ����
			role = (Role)sqlSession.selectOne("com.learn.ssm.chapter3.mapperInterface.RoleMapper.getRole", id);
			sqlSession.commit();  // �ύ����
		} catch (Exception e) {
			sqlSession.rollback();  // �ع�����
		} finally {
			// ��finally�����ȷ����Դ��˳���ر�
			if(sqlSession != null) {
				sqlSession.close(); 
			}
		}
		return role;
	}
	
	/**
	 * ��Mapper�ӿڷ���SQL
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
