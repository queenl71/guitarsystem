package com.guitar.tables;
/**
 * Guitar类
 * 一个PO类
 * @author lzm
 *
 */
public class Guitar {
	//Guitar的基本属性
	private String serialNumber;
	private String builder;
	private String model;
	private String type;
	private String backWood;
	private String topWood;
	private String price;
	
	//空构造器
	public Guitar() {
	}
	
	//带参构造
	public Guitar(String serialNumber, String builder, String model, String type, String backWood, String topWood,
			String price) {
		super();
		this.serialNumber = serialNumber;
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
		this.price = price;
	}
	
	//一下为各个属性的get() set()方法
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
