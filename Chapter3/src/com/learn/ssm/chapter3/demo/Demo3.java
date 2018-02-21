package com.learn.ssm.chapter3.demo;

import org.apache.ibatis.session.SqlSession;

/**
 * ����SqlSession
 * @author ahao
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			// ��SqlSession�Ự
			sqlSession = Demo1.getSqlSessionFactory().openSession();
			// some code ...
			sqlSession.commit(); // �ύ����
		} catch (Exception e) {
			sqlSession.rollback(); // �����쳣�ع�����
		} finally {
			// ��finally�����ȷ����Դ��˳���ر�
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
