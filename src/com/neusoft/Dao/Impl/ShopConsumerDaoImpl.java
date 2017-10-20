package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.Dao.DaoException;
import com.neusoft.Dao.ShopConsumerDao;
import com.neusoft.entity.Shoppinginfo_Consumer;
import com.neusoft.utils.ConnectionFactory;
import com.neusoft.utils.PageModel;

/**
 * 买家个人信息实现类
 * @author Administrator
 *
 */
public class ShopConsumerDaoImpl implements ShopConsumerDao {

	
	QueryRunner qr = new QueryRunner();
	
	@Override
	public boolean insertShopCsm(Shoppinginfo_Consumer sc ) throws DaoException {
		String sql = "insert into Shoppinginfo_Consumer(aid,nickname,money,lasttime) values(?,?,?,?)";
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, sc.getAid(), sc.getNickname(), sc.getMoney(), sc.getLasttime());
			if ( count > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("插入买家购物信息出错",e);
		}
		return false;
	}

	@Override
	public boolean updateShopCsm(Shoppinginfo_Consumer sc ) throws DaoException {
		String sql = "update Shoppinginfo_Consumer set aid = ?, nickname = ?, money = ?, lasttime = ? where id = ?";
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, sc.getAid(), sc.getNickname(), sc.getMoney(), sc.getLasttime(), sc.getId());
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("修改买家购物信息出错",e);
		}
		return false;
	}

	@Override
	public boolean delShopCsm(int id) throws DaoException {
		String sql = "delete from Shoppinginfo_Consumer where id = ?";
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, id);
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("删除买家购物信息出错",e);
		}
		return false;
	}

	@Override
	public Shoppinginfo_Consumer selectShopCsmById(int id) throws DaoException {
		      Shoppinginfo_Consumer cate=null;
		//获取连接
				Connection conn=ConnectionFactory.getInstance().getConnection();
				System.out.println("=====");
				//sql语句  cid,cname,pid
				String sql="select id,aid,nickname,money,lasttime from Shoppinginfo_Consumer where id=?";
				System.out.println(sql);
				try {
				     cate=new Shoppinginfo_Consumer();
					 cate=qr.query(conn, sql, new BeanHandler<Shoppinginfo_Consumer>(Shoppinginfo_Consumer.class), id);
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					 throw new DaoException("根据cid获取类别出错", e);
				}finally {
					DbUtils.closeQuietly(conn);
				}
	
		return cate;
	
	}

	@Override
	public PageModel<Shoppinginfo_Consumer> selectShopCsmAll(int pageNo, int pageSize) throws DaoException {
		PageModel<Shoppinginfo_Consumer>  model=null;
		
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
			System.out.println("链接成功");	
		 //sql
		String totalcount_sql="select count(id) from Shoppinginfo_Consumer";
		//查询总的记录  ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		try {
			Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
			System.out.println(totalcount);
			if(totalcount>0) {
				model=new PageModel<Shoppinginfo_Consumer>();
				model.setTotalRecords(totalcount);
				String sql="select id,aid,nickname,money,lasttime from Shoppinginfo_Consumer order by id desc limit ?,?";
			    Object[] params= {(pageNo-1)*pageSize,pageSize};
			    System.out.println((pageNo-1)*pageSize);
			    System.out.println(pageSize);
			    System.out.println(sql);
				List<Shoppinginfo_Consumer> msgs=qr.query(conn, sql, new BeanListHandler<Shoppinginfo_Consumer>(Shoppinginfo_Consumer.class), params);
			 
				model.setList(msgs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("分页查询出错。。。",e);
		}finally {
			
			DbUtils.closeQuietly(conn);
		}
		
		  
		
		
		return model;
		
	}

	@Override
	public int getAccPrototalcount() throws DaoException {
		String sql = "select count(id) from Shoppinginfo_Consumer ";
		int num = 0; 
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();
			Object obj = qr.query(conn, sql, new ScalarHandler<Object>());
			num = Integer.parseInt(obj.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
