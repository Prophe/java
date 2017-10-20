package com.neusoft.Dao;

import java.util.List;

import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.PageModel;

public interface OrderinfoDao {
	//查询全部订单 
	public PageModel<Orderinfo> getPageModel(int pageNo,int pagesize) throws DaoException;
	//根据订单状态分页查询
	public PageModel<Orderinfo> getPageModelByS(int pageNo,int pagesize,int orderstatus) throws DaoException;
	//查询orderstatus  =1：未付款
	public List<Orderinfo> getweifukuan() ;
	//查询orderstatus  =2：已付款
	public List<Orderinfo> getyifukuan() throws DaoException;
	//查询orderstatus  =3：已发货
	public List<Orderinfo> getyifahuo() throws DaoException;
	//查询orderstatus  =4：已完成
	public List<Orderinfo> getyiwancheng() throws DaoException;
	//通过ID查询指定订单
	public Orderinfo getByid(int id);
	//通过订单号查询订单信息
	
	
	//通过id修改数据
	public boolean upOrdByid(Orderinfo order);
	//插入数据
	public boolean addorder(Orderinfo order);
	//根据id删除
	public boolean deleOrdByid(int id);
	//根据addrinfo(登录id）查询
	public List<Orderinfo> getOrdByaddrinfo(int id);
	}
