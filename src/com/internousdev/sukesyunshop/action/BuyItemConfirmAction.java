package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.Map;

import com.internousdev.sukesyunshop.dao.TempBuyItemConfirmDAPO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport {

	private Map<String, Object> session;

	public String execute() {

		boolean loginFlag = session.get(SessionName.getLoginFlag()).equals(SessionName.getTrue());

		if(loginFlag){
			String userId = session.get(SessionName.getUserId()).toString();
			String tempUserId = session.get(SessionName.getTempUserId()).toString();
			TempBuyItemConfirmDAPO dao = new TempBuyItemConfirmDAPO();
			try {
				dao.convertId(userId, tempUserId);
			} catch (SQLException e) {
				return ERROR;
			}
			return SUCCESS;
		}

		return "login";
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
