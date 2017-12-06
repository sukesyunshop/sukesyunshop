package com.internousdev.sukesyunshop.util;

import java.util.UUID;

public class RandomID {

	private String tempId;

	public RandomID(){
		tempId = UUID.randomUUID().toString();
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

}
