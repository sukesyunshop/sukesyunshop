package com.internousdev.sukesyunshop.dto;

public class CartDTO extends CatalogDTO{

	private int id;
	private int userId;
	private int productId;

	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setId(int id) {
		this.id = id;
	}

}