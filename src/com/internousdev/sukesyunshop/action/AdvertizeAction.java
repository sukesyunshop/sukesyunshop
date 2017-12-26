package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdvertizeAction extends ActionSupport implements SessionAware {

	/*
	 * 広告の並び順の指定
	 */
	private String sort;

	/*
	 * 検索結果のDTOを保管するリスト
	 * CatalogActionと同名にする必要あり
	 */
	private ArrayList<CatalogDTO> catalogDTOList;

	/*
	 * CatalogDTOListのDTO数を格納
	 */
	private int listSize;

	/*
	 * カテゴリーのDTOをいれるリスト
	 */
	private ArrayList<CategoryDTO> categoryList;

	/*
	 * 取得結果がなかった場合のエラー用メッセージ
	 */
	private String emptyMessage="";

	/*
	 * セッション情報を格納する
	 */
	private Map<String, Object> session;

	public String execute(){
		String result = SUCCESS;
		SearchDAO dao = new SearchDAO();
		int[] id = null;

		if(sort.equals("sale")) {
			id = new int[]{1, 5, 6, 7, 12, 15, 19, 28, 34, 35, 36, 43, 45};
		} else if(sort.equals("anime")) {
			id = new int[]{12, 14, 15, 17, 19, 20};
		}

		try {
			setCatalogDTOList(dao.getSaleCatalogList(id));

			if(id != null) {
				listSize = id.length / 9;
			} else {
				listSize = 0;
			}

			if(catalogDTOList.size() == 0) {
				emptyMessage = "検索結果がありません";
			}

			setCategoryList(dao.getCategory());

		} catch (SQLException e) {
			e.printStackTrace();
			result = ERROR;
		}

		return result;
	}

	/**
	 * @return sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort セットする sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return catalogDTOList
	 */
	public ArrayList<CatalogDTO> getCatalogDTOList() {
		return catalogDTOList;
	}

	/**
	 * @param catalogDTOList セットする catalogDTOList
	 */
	public void setCatalogDTOList(ArrayList<CatalogDTO> catalogDTOList) {
		this.catalogDTOList = catalogDTOList;
	}

	/**
	 * @return listSize
	 */
	public int getListSize() {
		return listSize;
	}

	/**
	 * @param listSize セットする listSize
	 */
	public void setListSize(int listSize) {
		this.listSize = listSize;
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
	 * @return emptyMessage
	 */
	public String getEmptyMessage() {
		return emptyMessage;
	}

	/**
	 * @param emptyMessage セットする emptyMessage
	 */
	public void setEmptyMessage(String emptyMessage) {
		this.emptyMessage = emptyMessage;
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

}
