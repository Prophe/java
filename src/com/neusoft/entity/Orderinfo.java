package com.neusoft.entity;

public class Orderinfo {
	 
			   
	private int  id  ;      // 订单id
	private String	 orderno ;   // 订单编号
	private int orderstatus ;     //   ,-- 订单状态     1:未付款 2:已付款 3:已发货 4:已完成
	private int  paystatus ;         // ,-- 1:线上支付  2：货到付款
	private long	ordertime  ;   //  ,-- 下单时间
	private long		  paytime ;//     bigint    ,-- 付款时间
	private int  addrinfo ;       //  ,-- 收货人信息，引用自cosumer_addr表中的id
	private String	  mask;       //  varchar(200) -- 备注信息
	public Orderinfo() {
		super();
	}
	public Orderinfo(int id, String orderno, int orderstatus, int paystatus, long ordertime, long paytime, int addrinfo,
			String mask) {
		super();
		this.id = id;
		this.orderno = orderno;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinfo = addrinfo;
		this.mask = mask;
	}
	public Orderinfo(String orderno, int orderstatus, int paystatus, long ordertime, long paytime, int addrinfo,
			String mask) {
		super();
		this.orderno = orderno;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinfo = addrinfo;
		this.mask = mask;
	}
	@Override
	public String toString() {
		return "Orderinfo [id=" + id + ", orderno=" + orderno + ", orderstatus=" + orderstatus + ", paystatus="
				+ paystatus + ", ordertime=" + ordertime + ", paytime=" + paytime + ", addrinfo=" + addrinfo + ", mask="
				+ mask + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public long getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(long ordertime) {
		this.ordertime = ordertime;
	}
	public long getPaytime() {
		return paytime;
	}
	public void setPaytime(long paytime) {
		this.paytime = paytime;
	}
	public int getAddrinfo() {
		return addrinfo;
	}
	public void setAddrinfo(int addrinfo) {
		this.addrinfo = addrinfo;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
			
}
