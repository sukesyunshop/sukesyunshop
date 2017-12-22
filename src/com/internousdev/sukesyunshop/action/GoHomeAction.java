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
	private ArrayList<CatalogDTO> newArriveList;
	public Map<String, Object> session;

	private String sale = "sale";
	private String anime = "anime";

	public String execute() {

		// TODO 今後ホームに何を表示するかによって取得する値を変更します

		SearchDAO searchDAO = new SearchDAO();
		CatalogDAO catalogDAO = new CatalogDAO();
		try {
			setCateList(searchDAO.getCategory());
			setRandomList(catalogDAO.getRandomItem());
			setNewArriveList(searchDAO.getNewArriveList());
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

	public ArrayList<CatalogDTO> getNewArriveList() {
		return newArriveList;
	}

	public void setNewArriveList(ArrayList<CatalogDTO> newArriveList) {
		this.newArriveList = newArriveList;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getAnime() {
		return anime;
	}

	public void setAnime(String anime) {
		this.anime = anime;
	}
}