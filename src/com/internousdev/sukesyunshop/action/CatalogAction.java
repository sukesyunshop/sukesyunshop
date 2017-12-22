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

	public Map<String, Object> session;
	private CatalogDAO catalogDAO = new CatalogDAO();
	private ArrayList<CategoryDTO> cateList;
	private ArrayList<CatalogDTO> list;
	private int listSize;
	private int page=1;
	private String emptyMessage;


	private String result = ERROR;
	public String execute(){

		try{
			list=catalogDAO.getCatalogList(page);
				if(list.size() == 0){
					emptyMessage = "検索結果がありません";
				}
			listSize = catalogDAO.getCatalogCount()/9;
			SearchDAO searchDAO = new SearchDAO();
			setCateList(searchDAO.getCategory());
			result = SUCCESS;
		} catch (Exception e){
			e.printStackTrace();
		}
		return result;

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


}