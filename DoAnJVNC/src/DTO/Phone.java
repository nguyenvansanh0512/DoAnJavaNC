package DTO;

import java.util.Date;

public class Phone {
	int id;
	String name;
	float price;
	Date day;
	int quantity;
	public Phone(int id, String name, float price, Date day, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.day = day;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
