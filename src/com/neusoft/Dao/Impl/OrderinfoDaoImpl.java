package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.neusoft.Dao.DaoException;
import com.neusoft.Dao.OrderinfoDao;
import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.ConnectionFactory;

public class OrderinfoDaoImpl implements OrderinfoDao {

	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	//Account_Consumer consumer=null;
	Statement st=null;
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Orderinfo> consumerList=new ArrayList<Orderinfo>();
	@Override
	public PageModel<Orderinfo> getPageModel(int pageNo, int pagesize) throws DaoException {
		PageModel<Orderinfo> model=null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
		
		//准备sql
		String totalcount_sql="select count(id) from orderinfo";
		//查询总的记录 ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		
		Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
		if(totalcount>0){
			model=new PageModel<Orderinfo>();
			model.setTotalcount(totalcount);
			//分页查询
			String sql="select * from orderinfo order by id desc limit ?,?";
			Object[] params={(pageNo-1)*pagesize,pagesize};
			List<Orderinfo> orderinfo=qr.query(conn, sql, new BeanListHandler<Orderinfo>(Orderinfo.class),params);
			model.setDatas(orderinfo);
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("分页查询出错",e);
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return model;
	}
	@Override
	public PageModel<Orderinfo> getPageModelByS(int pageNo, int pagesize, int orderstatus) throws DaoException {
		// TODO Auto-generated method stub
		PageModel<Orderinfo> model=null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
		
		//准备sql
		String totalcount_sql="select count(id) from orderinfo ";
		//查询总的记录 ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		
		Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
		if(totalcount>0){
			model=new PageModel<Orderinfo>();
			model.setTotalcount(totalcount);
			//分页查询
			String sql="select * from orderinfo order by id desc limit ?,?";
			Object[] params={(pageNo-1)*pagesize,pagesize};
			List<Orderinfo> orderinfo=qr.query(conn, sql, new BeanListHandler<Orderinfo>(Orderinfo.class),params);
			model.setDatas(orderinfo);
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("分页查询出错",e);
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return model;
	}
	
	@Override
	public List<Orderinfo> getweifukuan() throws DaoException {
		List<Orderinfo> list = null;
		
		try {
			conn =ConnectionFactory.getInstance().getConnection();
			String sql = "select * from orderinfo where orderstatus=1";
			ResultSetHandler<List<Orderinfo>> rsh = new BeanListHandler<Orderinfo>(Orderinfo.class);
			list = qr.query(conn, sql, rsh);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return list;
	}
	@Override
	public List<Orderinfo> getyifukuan() throws DaoException {
List<Orderinfo> list = null;
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "select orderno,orderstatus,paystatus,ordertime,paytime,addrinfo,mask from orderinfo where orderstatus=2";
			ResultSetHandler<List<Orderinfo>> rsh = new BeanListHandler<Orderinfo>(Orderinfo.class);
			list = qr.query(conn, sql,  rsh);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		return list;
	}
	@Override
	public List<Orderinfo> getyifahuo() throws DaoException {
List<Orderinfo> list = null;
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "select * from orderinfo where orderstatus=3";
			ResultSetHandler<List<Orderinfo>> rsh = new BeanListHandler<Orderinfo>(Orderinfo.class);
			list = qr.query(conn, sql, rsh);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		return list;
	}
	@Override
	public List<Orderinfo> getyiwancheng() throws DaoException {
       List<Orderinfo> list = null;
		
		try {
			conn =ConnectionFactory.getInstance().getConnection();
			String sql = "select * from orderinfo where orderstatus=4";
			ResultSetHandler<List<Orderinfo>> rsh = new BeanListHandler<Orderinfo>(Orderinfo.class);
			list = qr.query(conn, sql , rsh);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		return list;
	}
	@Override
	public Orderinfo getByid(int id) {
		Orderinfo o=null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			String sql ="select * from orderinfo where id = ?";
			ResultSetHandler<Orderinfo> rsh = new BeanHandler<Orderinfo>(Orderinfo.class);
			o = qr.query(conn, sql, rsh,id);
			System.out.println(o);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return o;
	}
	@Override
	public boolean addorder(Orderinfo order) {
	try {
		conn = ConnectionFactory.getInstance().getConnection();
		String sql = "insert into orderinfo(orderno,orderstatus,paystatus,ordertime,paytime,addrinfo,mask ) values(?,?,?,?,?,?,?)";
		int count = qr.update(conn, sql,order.getOrderno(),order.getOrderstatus(),order.getPaystatus(),order.getAddrinfo(),order.getMask());
		if(count>0){
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DbUtils.closeQuietly(conn);
	}
		return false;
	}
	@Override
	public boolean upOrdByid(Orderinfo order) {
		// TODO Auto-generated method stub
		try {
			/*
			 * UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
			 * **/
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "update orderinfo set orderstatus=?,paystatus=?,ordertime=?,paytime=?,addrinfo=?,mask=? where id=?";
			int count = qr.update(conn, sql,order.getOrderstatus(),order.getPaystatus(),order.getAddrinfo(),order.getMask(),order.getId());
			if(count>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
			return false;
	}
	@Override
	public boolean deleOrdByid(int id) {
		// TODO Auto-generated method stub
	
		try {//delete from employee
			conn=ConnectionFactory.getInstance().getConnection();
			String sql = "delete from orderinfo where id=?";
			int count = qr.update(conn, sql,id);
			if(count>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return false;
		
	}
	@Override
	public List<Orderinfo> getOrdByaddrinfo(int id) {
		// TODO Auto-generated method stub
        List<Orderinfo> list = null;
		
		try {
			conn =ConnectionFactory.getInstance().getConnection();
			String sql = "select * from orderinfo where orderstatus=4";
			ResultSetHandler<List<Orderinfo>> rsh = new BeanListHandler<Orderinfo>(Orderinfo.class);
			list = qr.query(conn, sql , rsh);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		return list;
	}
}
