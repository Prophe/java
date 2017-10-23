package com.neusoft.entity;

import java.io.Serializable;

/**
 * 买家地址信息实体类
 * @author Administrator
 *
 */
public class Consumer_Addr implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3386462447290057945L;
	private int id;
	private String name;	//买家姓名
	private String addr;	//买家详细地址
	private String phone;	//联系方式
	private String provice;		//省
	private String city;		//市
	private String area;		//区
	
	public Consumer_Addr(int id, String name, String addr, String phone, String provice, String city, String area) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.provice = provice;
		this.city = city;
		this.area = area;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "Consumer_Addr [id=" + id + ", name=" + name + ", addr=" + addr + ", phone=" + phone + ", provice="
				+ provice + ", city=" + city + ", area=" + area + "]";
	}
	
	
	
	
}
