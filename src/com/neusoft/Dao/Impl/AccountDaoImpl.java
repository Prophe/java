package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.neusoft.Dao.AccountDao;
import com.neusoft.Dao.DaoException;
import com.neusoft.entity.Account_Consumer;
import com.neusoft.utils.ConnectionFactory;


/**
 * 
 * 
 *
 */
public class AccountDaoImpl implements AccountDao {
	
	Connection conn = null;
	QueryRunner qr = new QueryRunner();
	
	public AccountDaoImpl() {
		conn = ConnectionFactory.getInstance().getConnection();
	}
/**select id loginname,password,registertime,lastlogintime,ip from account_consumer where loginname = "张三" and password = "" [张三, 1234]
 * select loginname,password,registertime,lastlogintime,ip from account_consumer where loginname ='张三' and password = 1234 Parameters: [张三, 1234]
 * */
	@Override
	public Account_Consumer doLogin(Account_Consumer mAcc) throws DaoException {
		Account_Consumer acc = null;
		String sql = "select id, loginname,password,registertime,lastlogintime,ip from account_consumer where loginname =? and password =?";
		System.out.println(sql);
		try {
			acc = qr.query(conn, sql, new BeanHandler<Account_Consumer>(Account_Consumer.class), mAcc.getLoginname(),mAcc.getPassword());
			if(acc!=null){
				return acc;
			}
		} catch (SQLException e) {
			throw new DaoException("查询用户信息出错",e);
		}
		return acc;
	}

	@Override
	public boolean updateAccount(Account_Consumer acc) throws DaoException {
		String sql = "update account_consumer set ip = ?,lastlogintime = ? where id = ?";
		try{
			int count = qr.update(conn, sql,acc.getIp(),acc.getLastlogintime(),acc.getId());
			if(count>0){
				return true;
			}
		}catch (SQLException e) {
			throw new DaoException("修改用户信息出错",e);
		}
		return false;
	}
	
}
