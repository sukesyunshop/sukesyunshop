package com.internousdev.sukesyunshop.dto;

public class BuyItemDTO extends UserInfoDTO {

	private int itemId;
	private String itemName;
	private String itemNameKana;
	private String itemDescription;
	private int categoryId;
	private int price;
	private String imageFilePath;
	private String imageFileName;
	private String releaseDate;
	private String releaseCompany;
	private int status;


	public int getItemId() {

		return itemId;
	}

	public void setItemId(int itemId) {

		this.itemId = itemId;
	}

	public String getItemName() {

		return itemName;
	}

	public void setItemName(String itemName) {

		this.itemName = itemName;
	}

	public String getItemNameKana() {

		return itemNameKana;
	}

	public void setItemNameKana(String itemNameKana) {

		this.itemNameKana = itemNameKana;

	}

	public String getItemDescription() {

		return itemDescription;

	}

	public void setItemDescription(String itemDescription) {

		this.itemDescription = itemDescription;

	}

	public int getCategoryId() {

		return categoryId;

	}

	public void setCategoryId(int categoryId) {

		this.categoryId = categoryId;

	}

	public int getPrice() {

		return price;

	}

	public void setPrice(int price) {

		this.price = price;

	}

	public String getImageFilePath() {

		return imageFilePath;

	}

	public void setImageFilePath(String imageFilePath) {

		this.imageFilePath = imageFilePath;

	}

	public String getImageFileName() {

		return imageFileName;

	}

	public void setImageFileName(String imageFileName) {

		this.imageFileName = imageFileName;

	}

	public String getReleaseDate() {

		return releaseDate;

	}

	public void setReleaseDate(String releaseDate) {

		this.releaseDate = releaseDate;

	}

	public String getReleaseCompany() {

		return releaseCompany;

	}

	public void setReleaseCompany(String releaseCompany) {

		this.releaseCompany = releaseCompany;

	}

	public int getStatus() {

		return status;

	}

	public void setStatus(int status) {

		this.status = status;

	}

}
