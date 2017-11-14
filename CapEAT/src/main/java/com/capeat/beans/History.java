
	package com.capeat.beans;

	import java.sql.Date;

	public class History {
		
	private int orderId;
	private Date orderDate;
	private int orderQuantity;
	private int spiceLevel;
	private String itemName;
	private String itemDesc;
	private String itemPrice;
	private String orderLocation;
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	public History(int orderId, Date orderDate, int orderQuantity, int spiceLevel, String itemName, String itemDesc,
			String itemPrice, String orderLocation) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
		this.spiceLevel = spiceLevel;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.orderLocation = orderLocation;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public int getSpiceLevel() {
		return spiceLevel;
	}
	public void setSpiceLevel(int spiceLevel) {
		this.spiceLevel = spiceLevel;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getOrderLocation() {
		return orderLocation;
	}
	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}
	@Override
	public String toString() {
		return "History [orderId=" + orderId + ", orderDate=" + orderDate + ", orderQuantity=" + orderQuantity
				+ ", spiceLevel=" + spiceLevel + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", itemPrice="
				+ itemPrice + ", orderLocation=" + orderLocation + "]";
	}
	
	
	
	
	}

