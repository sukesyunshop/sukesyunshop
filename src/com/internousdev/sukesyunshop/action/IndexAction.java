package com.internousdev.sukesyunshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.util.RandomID;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements SessionAware {

	/*
	 * セッション情報を格納するマップ
	 */
	private Map<String, Object> session;

	public String execute() {
		String result = SUCCESS;
		RandomID randomId = new RandomID();
		session.put(SessionName.getTempUserId(), randomId.getTempId());
		session.put(SessionName.getLoginFlag(), SessionName.getFalse());

		return result;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session セットする session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
