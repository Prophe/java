package com.neusoft.entity;

import java.io.Serializable;
/**
 * 购物车
 */
public class CartItem implements Serializable{

	
	private static final long serialVersionUID = 6981495531212983121L;
	
	private Product product; //购买的商品  
	private int quantity;   //数量
	private double price;//对此类商品的价格计算（小计） 
	public CartItem() {
		super();
	}
	
	public CartItem(Product product) {
		super();
		this.product = product;
	}

	
	public CartItem(Product product, double price) {
		super();
		this.product = product;
		this.price = price;
	}

	public CartItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public CartItem(Product product, int quantity, double price) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.price=this.product.getPrice()*this.quantity;//商品的单价乘以数量 
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
	}
	 
}
