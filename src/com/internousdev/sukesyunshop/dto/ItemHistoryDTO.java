package com.internousdev.sukesyunshop.dto;

public class ItemHistoryDTO {

	private String userId;

	private int productId;

	private String password;

	private String productName;

	private String productNameKana;

	private String imageFilePath;

	private int Price;

	private String releaseCompany ;

	private String  releaseDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int i) {
		this.productId = i;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


}
