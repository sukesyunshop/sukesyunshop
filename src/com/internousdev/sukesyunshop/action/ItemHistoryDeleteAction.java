package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.MyPageDAO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class ItemHistoryDeleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	public String execute(){
		MyPageDAO deleteMyPageDAO= new MyPageDAO();
		String userId=session.get(SessionName.getUserId()).toString();
		try {
			deleteMyPageDAO.deleteItemHistory(userId);

			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session=session;

	}
}
