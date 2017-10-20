package com.neusoft.cart_service;

import java.util.List;

import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.ShoppingBagDao;
import com.neusoft.entity.Product;
import com.neusoft.entity.ShoppingBag;

public class ShoppingBagService {
ShoppingBagDao sbd=DaoFactory.getInstance("shoppingBagDao");
	
	//��ѯȫ����Ʒ
	public List<Product> getAllProduct(){
		return sbd.getAllProduct();
	}
	//����id
	public Product findProduct(int id) {
//		System.out.println("shoppingservice"+id);
		return sbd.findProduct(id);
	}
	//ɾ����Ʒ
	public void deleteCartItem(int sid, ShoppingBag shoppingBag) {
		sbd.deleteCartItem(sid, shoppingBag);
	}
	//��չ��ﳵ
	public void clearCart(ShoppingBag shoppingBag) {
		sbd.clearCart(shoppingBag);
	}
	//�ı�����
	public void changeQuantity(int sid, int quantity, ShoppingBag shoppingBag) {
		 sbd.changeQuantity(sid, quantity, shoppingBag);
	}
}
