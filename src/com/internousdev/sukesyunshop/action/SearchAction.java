package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware {

	/*
	 * 検索テキストを保管する変数
	 */
	private String searchText;

	/*
	 * 検索カテゴリを保管する変数
	 */
	private int categoryId;

	/*
	 * 検索結果のDTOを保管するリスト
	 * CatalogActionと同名にする必要あり
	 */
	private ArrayList<CatalogDTO> catalogDTOList;

	/*
	 * カテゴリ一覧のリスト
	 */
	private ArrayList<CategoryDTO> categoryList;

	/*
	 * 検索結果のDTOを保管するリスト（catalogDTOList）のサイズを保管するリスト
	 * CatalogActionと同名にする必要あり
	 */
	private int listSize;

	/*
	 * 検索結果を何ページにするかを保管する変数
	 * CatalogActionと同名にする必要あり
	 */
	private int page = 1;

	/*
	 * 検索結果が何もなかった場合にエラーを出す変数
	 * CatalogActionと同名にする必要あり
	 */
	private String emptyMessage = "";

	/*
	 * セッション情報を格納するマップ
	 */
	private Map<String, Object> session;

	public String execute(){
		String result = SUCCESS;
		SearchDAO searchDAO = new SearchDAO();

		try {
			setCatalogDTOList(searchDAO.searchCatalog(categoryId, searchText, page));
			setListSize(searchDAO.getCatalogCount(categoryId, searchText, page) / 9 + 1);

			if(catalogDTOList.size() == 0) {
				emptyMessage = "検索結果がありません";
			}

			setCategoryList(searchDAO.getCategory());
		} catch (SQLException e) {
			e.printStackTrace();
			result = ERROR;
		}

		return result;
	}

	/**
	 * @return searchText
	 */
	public String getSearchText() {
		return searchText;
	}

	/**
	 * @param searchText セットする searchText
	 */
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	/**
	 * @return categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId セットする categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	 * @return page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page セットする page
	 */
	public void setPage(int page) {
		this.page = page;
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
