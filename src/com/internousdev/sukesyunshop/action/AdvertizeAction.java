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

	private String sort;

	private ArrayList<CatalogDTO> list;
	private ArrayList<CategoryDTO> cateList;
	private int listSize;
	private String emptyMessage;

	private Map<String, Object> session;

	public String execute(){
		SearchDAO dao = new SearchDAO();
		int[] id = null;
		if(sort.equals("sale")){
			id = new int[]{1, 5, 6, 7, 12, 15, 19, 28, 34, 35, 36, 43, 45};
		}else if(sort.equals("anime")){
			id = new int[]{12, 14, 15, 17, 19, 20};
		}
		try {
			list=dao.getSaleCatalogList(id);
			if(id != null){
				listSize = id.length/9;
			}else{
				listSize = 0;
			}
			if(list.size() == 0){
				emptyMessage = "検索結果がありません";
			}
			setCateList(dao.getCategory());

			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public ArrayList<CatalogDTO> getList() {
		return list;
	}

	public void setList(ArrayList<CatalogDTO> list) {
		this.list = list;
	}

	public ArrayList<CategoryDTO> getCateList() {
		return cateList;
	}

	public void setCateList(ArrayList<CategoryDTO> cateList) {
		this.cateList = cateList;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public String getEmptyMessage() {
		return emptyMessage;
	}

	public void setEmptyMessage(String emptyMessage) {
		this.emptyMessage = emptyMessage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
