package com.internousdev.sukesyunshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Result(name="success",value="inputDest.jsp")//chain先の画面
public class InputDestAction extends ActionSupport implements SessionAware{

	private String userId;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;

	private Map<String, Object> session;


	/*
	 * 宛先情報を更新するメゾット
	 */

	public String execute(){


	}




}
