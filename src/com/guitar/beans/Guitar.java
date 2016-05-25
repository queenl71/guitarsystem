package com.guitar.beans;

//Guitar建立实体类.JavaBean有来存储数据


public class Guitar {
	//Guitar
	private String serialNumber;
	private String price;
	private String model;
	private String type;
	private String backWood;
	private String topWood;
	private String builder;
	
	//
	public Guitar() {
	}
	
	//
	public Guitar(String serialNumber, String price, String model, String type, String backWood, String topWood,
			String builder) {
		super();
		this.serialNumber = serialNumber;
		this.price = price;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
		this.builder = builder;
	}
	
	//
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	public String Builder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getBuilder() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
