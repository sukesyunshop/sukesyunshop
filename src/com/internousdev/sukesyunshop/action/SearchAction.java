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

	private String searchText;
	private int categoryId;

	private ArrayList<CatalogDTO> list;
	private ArrayList<CategoryDTO> cateList;
	private int listSize;
	private int page;
	private String emptyMessage = "";

	private Map<String, Object> session;

	public String execute(){
		SearchDAO searchDAO = new SearchDAO();
		if(page==0) page=1;
		try {
			list = searchDAO.searchCatalog(categoryId, searchText, page);
			listSize = searchDAO.getCatalogCount(categoryId, searchText, page)/9+1;
			if(list.size() == 0){
				emptyMessage = "検索結果がありません";
			}
			setCateList(searchDAO.getCategory());

			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String getSearchText() {
		return searchText;
	}


	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public ArrayList<CatalogDTO> getList() {
		return list;
	}

	public void setList(ArrayList<CatalogDTO> list) {
		this.list = list;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getEmptyMessage() {
		return emptyMessage;
	}

	public void setEmptyMessage(String emptyMessage) {
		this.emptyMessage = emptyMessage;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public ArrayList<CategoryDTO> getCateList() {
		return cateList;
	}

	public void setCateList(ArrayList<CategoryDTO> cateList) {
		this.cateList = cateList;
	}

}
