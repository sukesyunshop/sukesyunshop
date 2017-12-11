package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.TempBuyItemConfirmDAPO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

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
				e.printStackTrace();
				return ERROR;
			}
			return SUCCESS;
		}

		session.put(SessionName.getBuying(), SessionName.getTrue());
		return "login";
	}

	public Map<String, Object> getSession() {
			return session;
		}
	@Override
	public void setSession(Map<String, Object> session) {
			this.session = session;
		}
}
