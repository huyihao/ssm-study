package com.learn.ssm.chapter3.demo;

import org.apache.ibatis.session.SqlSession;

/**
 * 创建SqlSession
 * @author ahao
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			// 打开SqlSession会话
			sqlSession = Demo1.getSqlSessionFactory().openSession();
			// some code ...
			sqlSession.commit(); // 提交事务
		} catch (Exception e) {
			sqlSession.rollback(); // 发生异常回滚事务
		} finally {
			// 在finally语句中确保资源被顺利关闭
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
