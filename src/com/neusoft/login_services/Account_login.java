package com.neusoft.login_services;

import com.neusoft.Dao.AccountDao;
import com.neusoft.Dao.Impl.AccountDaoImpl;
import com.neusoft.entity.Account_Consumer;

public class Account_login {

	
	
	public Account_Consumer Acclogin(Account_Consumer mAcc){
		AccountDao acc =new AccountDaoImpl();
		Account_Consumer mAcc1=null;
/**
 * 
 * update accounts set ip =0:0:0:0:0:0:0:1,logindate=1508123122834 where id = 1 Parameters: [0:0:0:0:0:0:0:1, 1508123122834, 1]
 * */
			System.out.println("���ݹ�����ҳ����Ϣ"+mAcc);
			mAcc1 = acc.doLogin(mAcc);
			System.out.println("Ҫ��ѯ����Ϣ mAcc1:"+mAcc1);
			if(mAcc1!=null){
				mAcc1.setIp(mAcc.getIp());
				mAcc1.setLastlogintime(System.currentTimeMillis());
				System.out.println("Ҫ�޸ĵ���Ϣ"+mAcc1);
				acc.updateAccount(mAcc1);
					
				
	  }
			return mAcc;
		
	}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
