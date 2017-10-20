package com.neusoft.Dao;

import java.util.List;

import com.neusoft.entity.Product;
import com.neusoft.entity.ShoppingBag;

public interface ShoppingBagDao {
	public List<Product> getAllProduct();  
    //��ȡָ��id����  
    public Product findProduct(int id);  
    //ɾ��������  
    public void deleteCartItem(int sid, ShoppingBag shoppingBag);  
    //��չ��ﳵ  
    public void clearCart(ShoppingBag shoppingBag);  
    /**
     * �ı����� 
     * */ 
    public void changeQuantity(int sid, int quantity, ShoppingBag shoppingBag);
}
