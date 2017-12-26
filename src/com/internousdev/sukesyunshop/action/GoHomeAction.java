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


	/*
	 * カテゴリーのDTOをいれるリスト
	 */
	private ArrayList<CategoryDTO> categoryList;

	/*
	 * pickup商品のDTOをいれるリスト
	 */
	private ArrayList<CatalogDTO> randomList;

	/*
	 * 新着商品のDTOをいれるリスト
	 */
	private ArrayList<CatalogDTO> newArriveList;

	/*
	 * セッション情報を格納するマップ
	 */
	private Map<String, Object> session;

	/*
	 * AdvertizeActionに情報にどのグループ情報かを伝える定数
	 */
	private final String SALE = "sale";

	/*
	 * AdvertizeActionに情報にどのグループ情報かを伝える定数
	 */
	private final String ANIME = "anime";

	public String execute() {
		String result = SUCCESS;
		SearchDAO searchDAO = new SearchDAO();
		CatalogDAO catalogDAO = new CatalogDAO();

		try {
			setCategoryList(searchDAO.getCategory());
			setRandomList(catalogDAO.getRandomItem());
			setNewArriveList(searchDAO.getNewArriveList());
		} catch (SQLException e) {
			e.printStackTrace();
			result = ERROR;
		}

		return result;
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

	/**
	 * @return randomList
	 */
	public ArrayList<CatalogDTO> getRandomList() {
		return randomList;
	}

	/**
	 * @param randomList セットする randomList
	 */
	public void setRandomList(ArrayList<CatalogDTO> randomList) {
		this.randomList = randomList;
	}

	/**
	 * @return newArriveList
	 */
	public ArrayList<CatalogDTO> getNewArriveList() {
		return newArriveList;
	}

	/**
	 * @param newArriveList セットする newArriveList
	 */
	public void setNewArriveList(ArrayList<CatalogDTO> newArriveList) {
		this.newArriveList = newArriveList;
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

	/**
	 * @return sale
	 */
	public String getSale() {
		return SALE;
	}

	/**
	 * @return anime
	 */
	public String getAnime() {
		return ANIME;
	}

}