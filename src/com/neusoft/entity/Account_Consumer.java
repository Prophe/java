package com.neusoft.entity;

import java.io.Serializable;


/**
 * ����ʺ���Ϣ
 * @author Administrator
 *
 */
public class Account_Consumer implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 21648327610572962L;

	private int id;	//���id
	private String loginname;	//�û���
	private String password;	//����
	private Long registertime;	//ע��ʱ��
	private long lastlogintime;	//���һ�ε�½ʱ��
	private String ip;
	public Account_Consumer(String loginname, String password) {
		super();
		this.loginname = loginname;
		this.password = password;
	}

	
	
	
	
	public int getId() {
		return id;
	}
	public Account_Consumer() {
		super();
	}





	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getRegistertime() {
		return registertime;
	}
	public void setRegistertime(Long registertime) {
		this.registertime = registertime;
	}
	public Long getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(Long lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "Account_Consumer [id=" + id + ", loginname=" + loginname + ", password=" + password + ", registertime="
				+ registertime + ", lastlogintime=" + lastlogintime + ", ip=" + ip + "]";
	}
	
	
	
	
	
}
