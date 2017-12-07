package com.internousdev.sukesyunshop.dto;

public class ItemHistoryDTO {

	private String userId;

	private String password;

	private varchar product_Name;

	private varchar product_Name_kana;

	private varchar image_file_path;

	private int price;

	private varchar release_company ;

	private datetime  release_date;

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId=userId;
	}

	public String getPassword(){
		return Password;
	}

	public void setPassword(String password){
	    this.password=password;
    }

	public varchar getProduct_Name(){
		return product_Name;
	}

	public void setProduct_Name(varchar product_Name){
		this.product_Name=product_Name;
	}

	public varchar getProduct_Name_kana(){
		return product_Name_kana;
	}

	public void setProduct_Name_kana(varchar product_Name_kana){
		this.product_Name_kana=product_Name_kana;
	}

	public varchar getImage_file_path(){
		return image_file_path;
	}

	public void setImage_file_path(varchar image_file_path){
		this.image_file_path=image_file_path;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price=price;
	}

	public varchar getRelease_company(){
		return release_company;
	}

	public void setRelease_company(varchar release_company){
		this.release_company=release_company;
	}

	public datetime getRelease_date(){
		return release_date;
	}

	public void setRelease_date(datetime release_date){
		this.release_date=release_date;
	}

}
