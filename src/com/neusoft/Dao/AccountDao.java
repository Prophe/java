package com.neusoft.Dao;

import com.neusoft.entity.Account_Consumer;

/**
 * �ʻ�dao
 * @author Administrator
 *
 */
public interface AccountDao {

	/**
	 * �û���¼
	 * **/
	public Account_Consumer doLogin(Account_Consumer acc) throws DaoException;
	/**
	 * ����id�޸ĵ�¼ip������¼ʱ��
	 * 
	 * **/
	public boolean updateAccount(Account_Consumer acc) throws DaoException;
}
