package com.learn.ssm.chapter3.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.learn.ssm.chapter3.mapperInterface.RoleMapper;
import com.learn.ssm.chapter3.pojo.Role;
import com.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;

public class Chapter3Main {
	public static void main(String[] args) {		
		Logger log = Logger.getLogger(Chapter3Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			log.info(role.getRoleName());
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
