package com.learn.ssm.chapter4.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.learn.ssm.chapter4.mapperInterface.RoleMapper;
import com.learn.ssm.chapter4.pojo.Role;
import com.learn.ssm.chapter4.utils.SqlSessionFactoryUtils;

public class TestProperties {
	public static void main(String[] args) {		
		Logger logger = Logger.getLogger(TestProperties.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setRoleName("assister");
			role.setNote("����");
			// ��
			roleMapper.insertRole(role);
			// ��
			Role sRole = roleMapper.getRole(4L);
			logger.info("{ id:" + sRole.getId() + ", role_name:" + sRole.getRoleName() 
							+ "note:" + sRole.getNote() + "}");
			// ��
			sRole.setNote("�����޸ĺ������");
			roleMapper.updateRole(sRole);
			logger.info("{ id:" + sRole.getId() + ", role_name:" + sRole.getRoleName() 
			+ "note:" + sRole.getNote() + "}");
			// ɾ
			roleMapper.deleteRole(3L);
			sqlSession.commit();
			logger.info("insert data success!");
		} finally {
			sqlSession.close();
			logger.info("close sqlSession!");
		}
	}
}
