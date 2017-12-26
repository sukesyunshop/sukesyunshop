package com.internousdev.sukesyunshop.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.CatalogDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;


public class CatalogAction extends ActionSupport implements SessionAware {

	/*
	 * セッション情報を格納するマップ
	 */
	public Map<String, Object> session;

	/*
	 * カテゴリ一覧のリスト
	 */
	private ArrayList<CategoryDTO> categoryList;

	/*
	 * 検索結果のDTOを保管するリスト
	 * CatalogActionと同名にする必要あり
	 */
	private ArrayList<CatalogDTO> catalogDTOList;

	/*
	 * 検索結果のDTOを保管するリスト（catalogDTOList）のサイズを保管するリスト
	 * CatalogActionと同名にする必要あり
	 */
	private int listSize;

	/*
	 * 検索結果を何ページにするかを保管する変数
	 * CatalogActionと同名にする必要あり
	 */
	private int page=1;

	/*
	 * 検索結果が何もなかった場合にエラーを出す変数
	 * CatalogActionと同名にする必要あり
	 */
	private String emptyMessage;

	public String execute(){
		String result = SUCCESS;
		SearchDAO searchDAO = new SearchDAO();
		CatalogDAO catalogDAO = new CatalogDAO();

		try {
			setCatalogDTOList(catalogDAO.getCatalogList(page));

			if(catalogDTOList.size() == 0) {
				emptyMessage = "検索結果がありません";
			}

			setListSize(catalogDAO.getCatalogCount() / 9 + 1);
			setCategoryList(searchDAO.getCategory());

		} catch (Exception e){
			e.printStackTrace();
			result = ERROR;
		}

		return result;
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

}