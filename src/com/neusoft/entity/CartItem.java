package com.neusoft.entity;

import java.io.Serializable;
/**
 * ���ﳵ
 */
public class CartItem implements Serializable{

	
	private static final long serialVersionUID = 6981495531212983121L;
	
	private Product product; //�������Ʒ  
	private int quantity;   //����
	private double price;//�Դ�����Ʒ�ļ۸���㣨С�ƣ� 
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
		this.price=this.product.getPrice()*this.quantity;//��Ʒ�ĵ��۳������� 
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
