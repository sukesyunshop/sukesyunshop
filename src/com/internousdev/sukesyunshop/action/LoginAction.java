package com.internousdev.sukesyunshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String userId;
	private String password;

	private Map<String, Object> session;
	private String message;

	private final String NAME_USER_ID ="ユーザーID";
	private final String NAME_PASSWORD ="パスワード";
	private final String NOT = "を入力してください";


	public String execute(){

		if(validation(userId, password) != null){
			message = validation(userId, password);
			return "";
		}
		

		return ERROR;
	}

	private String validation(String userId, String password){

		if(userId == null || userId.equals("")){
			return NAME_USER_ID+NOT;
		}else if(password == null || password.equals("")){
			return NAME_PASSWORD+NOT;
		}else if(userId.length() < 1 || userId.length() > 8){
			return userId+"は1文字以上8文字以下で入力してください。";
		}else if (password.length() < 1 || password.length() >16){
			return password+"は1文字以上16文字以下で入力してください。";
		}

		return null;
	}

	private String overUnder(String target, int min, int max){
		return target+"は"+min+"文字以上"+max+"文字以下で入力してください。";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String messsage) {
		this.message = messsage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
