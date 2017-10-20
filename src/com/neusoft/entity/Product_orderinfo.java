package com.neusoft.entity;

import java.io.Serializable;

/**
 * 订单id和商品的联系
 */
public class Product_orderinfo implements Serializable {

	
	private static final long serialVersionUID = -5205745768395564837L;

	
	/**
	 * 
	 *  orderid     int     ,-- 订单id 值引用自orderinfo表中的id
   productid   int     ,-- 商品id,值引用自product表中的id
	 * */
}
