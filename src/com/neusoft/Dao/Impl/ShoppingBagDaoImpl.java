package com.neusoft.Dao.Impl;

import java.util.List;

import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.ProductDao;
import com.neusoft.Dao.ShoppingBagDao;
import com.neusoft.entity.CartItem;
import com.neusoft.entity.Product;
import com.neusoft.entity.ShoppingBag;

public class ShoppingBagDaoImpl implements ShoppingBagDao{
	ProductDao pd=DaoFactory.getInstance("productDao");
	@Override
	public List<Product> getAllProduct() {
		return pd.getProList();
	}
	@Override
	public Product findProduct(int id) {
//		System.out.println("shoppingimpl"+id);
		return pd.getPro(id);
	}
	@Override
	public void deleteCartItem(int sid, ShoppingBag shoppingBag) {
		shoppingBag.getMap().remove(sid);
	}
	@Override
	public void clearCart(ShoppingBag shoppingBag) {
		shoppingBag.getMap().clear();
	}
	@Override
	public void changeQuantity(int sid, int quantity, ShoppingBag shoppingBag) {
		 CartItem item=shoppingBag.getMap().get(sid);  
	     item.setQuantity(quantity);
	}
}
