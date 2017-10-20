package test;

import java.util.List;

import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.ShopConsumerDao;
import com.neusoft.Dao.Impl.ShopConsumerDaoImpl;
import com.neusoft.entity.Shoppinginfo_Consumer;
import com.neusoft.utils.PageModel;

public class ShopConsTest {
	static ShopConsumerDao member=DaoFactory.getInstance("memner"); 
	public static void main(String[] args) {
	System.out.println("=========");
		//addCon();
		//member.delShopCsm(1);
		//getPrototalcountTest();
		//member.selectShopCsmById(1);
	ShopConsumerDao shop=new  ShopConsumerDaoImpl();
//	Double s=12321.1;
//	Long a=3243434L;
//	shop.insertShopCsm(new Shoppinginfo_Consumer(6, "浮生物语",s,a));
	//shop.selectShopCsmById(1);
	//System.out.println(shop.selectShopCsmById(1));
	 PageModel<Shoppinginfo_Consumer> shopinfo= shop.selectShopCsmAll(1, 3);
	 System.out.println(shopinfo.getPageNo());
	 System.out.println(shopinfo.getPageSize());
	    List<Shoppinginfo_Consumer> list=shopinfo.getList();
	    for (Shoppinginfo_Consumer shoppinginfo_Consumer : list) {
			System.out.println(shoppinginfo_Consumer);
		
		}
	
	}
	
	
	
	
	
	public static void addCon(){
		ShopConsumerDao shop=new  ShopConsumerDaoImpl();
		Double s=12321.1;
		Long a=3243434L;
		if(shop.insertShopCsm(new Shoppinginfo_Consumer(6, "浮生物语",s,a))){
			System.out.println("添加成功");
		};
		
	}
	
	
	public static int getPrototalcountTest(){
		
		return member.getAccPrototalcount();
		
		
		
		
	}
	public static PageModel<Shoppinginfo_Consumer> selectShopCsmAll(int pageNo, int pageSize){
		
		 PageModel<Shoppinginfo_Consumer> shopinfo= member.selectShopCsmAll(1, 3);
		    List<Shoppinginfo_Consumer> list=shopinfo.getList();
		    for (Shoppinginfo_Consumer shoppinginfo_Consumer : list) {
				System.out.println(shoppinginfo_Consumer);
			}
			return shopinfo;
		
		
	}
}
