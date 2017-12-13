package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.ItemHistoryDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class ItemHistoryDeleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<CategoryDTO> cateList;

	public String execute(){
		ItemHistoryDAO deleteItemHistoryDAO= new ItemHistoryDAO();
		String userId=session.get(SessionName.getUserId()).toString();
		try {
			deleteItemHistoryDAO.deleteItemHistory(userId);

			SearchDAO searchDAO = new SearchDAO();
			setCateList(searchDAO.getCategory());
			session.put(SessionName.getCategoryList(), getCateList());

			return SUCCESS;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return ERROR;
		}

	}

	public ArrayList<CategoryDTO> getCateList() {
		return cateList;
	}

	public void setCateList(ArrayList<CategoryDTO> cateList) {
		this.cateList = cateList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session=session;

	}
}
