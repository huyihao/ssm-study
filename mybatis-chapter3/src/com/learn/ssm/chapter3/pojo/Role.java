package com.learn.ssm.chapter3.pojo;

/**
 * POJO文件，成员变量与数据库中的字段对应
 * @author ahao
 *
 */
public class Role {
	private Long id;
	private String roleName;
	private String note;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
