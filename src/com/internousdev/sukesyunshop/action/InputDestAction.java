package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InputDestAction extends ActionSupport {

	public Map<String, Object> session;
	private ArrayList<CategoryDTO> categoryList;

	/*
	 * 宛先情報を登録する画面へ遷移
	 */
	public String execute() {
		SearchDAO searchDAO = new SearchDAO();
		try {
			setCategoryList(searchDAO.getCategory());
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}

		return SUCCESS;

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
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return categoryList
	 */
	public ArrayList<CategoryDTO> getCategoryList() {
		return categoryList;
	}

	/**
	 * @param categoryList セットする categoryList
	 */
	public void setCategoryList(ArrayList<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}


}
