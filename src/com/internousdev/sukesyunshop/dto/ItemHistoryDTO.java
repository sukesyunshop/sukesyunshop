package com.internousdev.sukesyunshop.dto;

public class ItemHistoryDTO {

	private String userId;

	private String password;

	private String product_Name;

	private String product_Name_kana;

	private String image_file_path;

	private int price;

	private String release_company ;

	private String  release_date;

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId=userId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
	    this.password=password;
    }

	public String getProduct_Name(){
		return product_Name;
	}

	public void setProduct_Name(String product_Name){
		this.product_Name=product_Name;
	}

	public String getProduct_Name_kana(){
		return product_Name_kana;
	}

	public void setProduct_Name_kana(String product_Name_kana){
		this.product_Name_kana=product_Name_kana;
	}

	public String getImage_file_path(){
		return image_file_path;
	}

	public void setImage_file_path(String image_file_path){
		this.image_file_path=image_file_path;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price=price;
	}

	public String getRelease_company(){
		return release_company;
	}

	public void setRelease_company(String release_company){
		this.release_company=release_company;
	}

	public String getRelease_date(){
		return release_date;
	}

	public void setRelease_date(String release_date){
		this.release_date=release_date;
	}

}
