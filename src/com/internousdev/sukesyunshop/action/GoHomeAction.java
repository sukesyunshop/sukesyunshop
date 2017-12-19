package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.CatalogDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware {

	private ArrayList<CategoryDTO> cateList;
	private ArrayList<CatalogDTO> randomList;
	public Map<String, Object> session;

	public String execute() {

		// TODO 今後ホームに何を表示するかによって取得する値を変更します

		SearchDAO searchDAO = new SearchDAO();
		CatalogDAO catalogDAO = new CatalogDAO();
		try {
			setCateList(searchDAO.getCategory());
			setRandomList(catalogDAO.getRandomItem());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CategoryDTO> getCateList() {
		return cateList;
	}

	public void setCateList(ArrayList<CategoryDTO> cateList) {
		this.cateList = cateList;
	}

	public ArrayList<CatalogDTO> getRandomList() {
		return randomList;
	}

	public void setRandomList(ArrayList<CatalogDTO> randomList) {
		this.randomList = randomList;
	}
}