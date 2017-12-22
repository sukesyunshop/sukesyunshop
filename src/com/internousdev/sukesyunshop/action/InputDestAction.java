package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InputDestAction extends ActionSupport {

	public Map<String, Object> session;
	private ArrayList<CategoryDTO> cateList;

	/*
	 * 宛先情報を登録する画面へ遷移
	 */
	public String execute() {
		SearchDAO searchDAO = new SearchDAO();
		try {
			setCateList(searchDAO.getCategory());
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}

		return SUCCESS;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CategoryDTO> getCateList() {
		return cateList;
	}

	public void setCateList(ArrayList<CategoryDTO> cateList) {
		this.cateList = cateList;
	}

}
