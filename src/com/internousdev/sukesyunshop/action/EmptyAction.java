package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class EmptyAction extends ActionSupport implements SessionAware {

	private ArrayList<CategoryDTO> cateList;
	private Map<String, Object> session;


	public String execute(){

		SearchDAO searchDAO = new SearchDAO();
		try {
			setCateList(searchDAO.getCategory());
			session.put(SessionName.getCategoryList(), getCateList());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public ArrayList<CategoryDTO> getCateList() {
		return cateList;
	}

	public void setCateList(ArrayList<CategoryDTO> cateList) {
		this.cateList = cateList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
