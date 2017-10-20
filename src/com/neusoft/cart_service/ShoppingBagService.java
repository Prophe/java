package com.neusoft.cart_service;

import java.util.List;

import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.ShoppingBagDao;
import com.neusoft.entity.Product;
import com.neusoft.entity.ShoppingBag;

public class ShoppingBagService {
ShoppingBagDao sbd=DaoFactory.getInstance("shoppingBagDao");
	
	//查询全部商品
	public List<Product> getAllProduct(){
		return sbd.getAllProduct();
	}
	//根据id
	public Product findProduct(int id) {
//		System.out.println("shoppingservice"+id);
		return sbd.findProduct(id);
	}
	//删除商品
	public void deleteCartItem(int sid, ShoppingBag shoppingBag) {
		sbd.deleteCartItem(sid, shoppingBag);
	}
	//清空购物车
	public void clearCart(ShoppingBag shoppingBag) {
		sbd.clearCart(shoppingBag);
	}
	//改变数量
	public void changeQuantity(int sid, int quantity, ShoppingBag shoppingBag) {
		 sbd.changeQuantity(sid, quantity, shoppingBag);
	}
}
