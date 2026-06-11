package com.order.event;

public class OrderCreatedEvent {

	private long id;
	private String productName;
	
	
	
	public OrderCreatedEvent() {
		
	}

	public OrderCreatedEvent(long id, String productName) {
		super();
		this.id = id;
		this.productName = productName;
	
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
