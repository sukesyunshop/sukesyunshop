package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.MyPageDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class ItemHistoryDeleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<CategoryDTO> cateList;

	public String execute(){
		MyPageDAO deleteMyPageDAO= new MyPageDAO();
		String userId=session.get(SessionName.getUserId()).toString();
		try {

			SearchDAO searchDAO = new SearchDAO();
			setCateList(searchDAO.getCategory());

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
		this.session=session;

	}

	public ArrayList<CategoryDTO> getCateList() {
		return cateList;
	}

	public void setCateList(ArrayList<CategoryDTO> cateList) {
		this.cateList = cateList;
	}
}
