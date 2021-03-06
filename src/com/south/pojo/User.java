package com.south.pojo;

import java.util.Date;

public class User {
	private Integer id;	//员工编号
	private String username;//员工用户名
	private String password;//登录密码
	private String sex;		//性别
	private Date birthday;	//生日
	private Date createtime;//创建时间
	private String content;	//人员简介

//	public User(Integer id, String username, String password, String sex, Date birthday, Date createtime, String content) {
//		this.id=id;
//		this.username = username;
//		this.password = password;
//		this.sex = sex;
//		this.birthday = birthday;
//		this.createtime = createtime;
//		this.content = content;
//	}

	public User() {
		super();
	}

	public Integer getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = Integer.valueOf(id);
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreatetime() {
		return this.createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
		StringBuffer toStr = new StringBuffer();
		toStr.append("[Users] = [\n");
		toStr.append("    id = " + this.id + ";\n");
		toStr.append("    username = " + this.username + ";\n");
		toStr.append("    password = " + this.password + ";\n");
		toStr.append("    sex = " + this.sex + ";\n");
		toStr.append("    birthday = " + this.birthday+ ";\n");
		toStr.append("    createtime = " + this.createtime+ ";\n");
		toStr.append("    content = " + this.content + ";\n");
		toStr.append("    ];\n");
		return toStr.toString();
	}
}
