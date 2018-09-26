package com.user.model;

public class Product {
	private int id;
	private String name;
	private String price;
	private String url;

	public Product() {
		super();
	}

	public Product(int id, String name, String price, String url) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.url = url;
	}
	
	public Product(String name, String price, String url) {
		super();
		this.name = name;
		this.price = price;
		this.url = url;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
