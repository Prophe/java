package com.neusoft.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingBag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2077508576648065466L;
	
	private Map<Integer,CartItem> map=new LinkedHashMap<Integer,CartItem>(); 
	private double price;
	
	public void add(Product product){
		CartItem item = map.get(product.getId());
		 if(item!=null){  
	            item.setQuantity(item.getQuantity()+1);  
	            System.out.println("�ϵ�map");
	        }else{  
	            item=new CartItem();  
	            item.setProduct(product);  
	            item.setQuantity(1);
	            item.setPrice(product.getPrice());
	            //���µĹ�������ӵ�map������  
	            map.put(product.getId(),item);
	            System.out.print("�µĵ�map  ");
	            System.out.println("����"+map.size());
	        } 
		}
	  public Map<Integer, CartItem> getMap() {  
	        return map;  
	    }  
	    public void setMap(Map<Integer, CartItem> map) {  
	        this.map = map;  
	    }  
	    public double getPrice() {  
	        double totalprice=0;  
	        for(Map.Entry<Integer, CartItem> me:map.entrySet()){  
	            CartItem item=me.getValue();  
	            totalprice+=item.getPrice();  
	        }  
	        this.price=totalprice;  
	        return price;  
	    }  
	    public void setPrice(double price) {  
	        this.price = price;  
	    }  
}
