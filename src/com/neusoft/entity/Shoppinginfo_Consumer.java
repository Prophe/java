package com.neusoft.entity;

import java.io.Serializable;

/**
 * 买家购物信息
 * @author Administrator
 *
 */
public class Shoppinginfo_Consumer implements Serializable {

	/**
	 *  id          int      primary key auto_increment,
   aid         int     ,-- 买家帐号id，依赖account_consumer表中的id
   nickname    varchar(20) ,-- 用户昵称
   money       double  ,-- 订单金额
   lasttime        bigint  -- 最近消费  
	 */
	private static final long serialVersionUID = 6627837547520953592L;
	
	private int id; 
	private int aid;	//买家购物信息id
	private String nickname; //昵称
	private Double money;	//话费金额
	private Long lasttime;	//最近消费
	
	
	
	public Shoppinginfo_Consumer() {
		super();
	}

	public Shoppinginfo_Consumer( int aid, String nickname, Double money, Long lasttime) {
		super();
		
		this.aid = aid;
		this.nickname = nickname;
		this.money = money;
		this.lasttime = lasttime;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Long getLasttime() {
		return lasttime;
	}
	public void setLasttime(Long lasttime) {
		this.lasttime = lasttime;
	}
	
	@Override
	public String toString() {
		return "Shoppinginfo_Consumer [id=" + id + ", aid=" + aid + ", nickname=" + nickname + ", money=" + money
				+ ", lasttime=" + lasttime + "]";
	}
	

}
