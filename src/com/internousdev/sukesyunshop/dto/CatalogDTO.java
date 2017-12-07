package com.internousdev.sukesyunshop.dto;

public class CatalogDTO {

	private int id;
	private String productName;
	private String productNameKana;
	private int price;
	private int release_date;
	private String release_company;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameKana() {
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRelease_date() {
		return release_date;
	}
	public void setRelease_date(int release_date) {
		this.release_date = release_date;
	}
	public String getRelease_company() {
		return release_company;
	}
	public void setRelease_company(String release_company) {
		this.release_company = release_company;
	}



}
