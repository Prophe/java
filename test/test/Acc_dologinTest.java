package test;

import com.neusoft.Dao.Impl.AccountDaoImpl;
import com.neusoft.entity.Account_Consumer;

public class Acc_dologinTest {

	
	public static void main(String[] args) {
		
	 	
	 	System.out.println(new  AccountDaoImpl().doLogin(new Account_Consumer("����","1234")));
	//	System.out.println(new  AccountDaoImpl().doLogin(new Account_Consumer(0,"����","1234",)));
	}
}
