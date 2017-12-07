package com.internousdev.sukesyunshop.action;

import com.opensymphony.xwork2.ActionSupport;

@Result(name="success",value="inputDest.jsp")//chain先の画面
public class InputDestAction extends ActionSupport {

	/*
	 * 宛先情報を登録する画面へ遷移
	 */
	public String execute(){

		return SUCCESS;



	}




}
