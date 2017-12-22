package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.MyPageDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class ItemHistoryAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	public ArrayList<CatalogDTO>  list ;
	private ArrayList<CategoryDTO> cateList;

	/**
	 * 商品購入情報取得メソッド
	 *
	 * @author internous
	 */
	public String execute() {
		MyPageDAO dao =new MyPageDAO ();
		String userId = session.get(SessionName.getUserId()).toString();

		try {
			SearchDAO searchDAO = new SearchDAO();
			setCateList(searchDAO.getCategory());

			list =dao.getItemHistoryList(userId);

			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * @return list
	 */
	public ArrayList<CatalogDTO> getList() {
		return list;
	}

	/**
	 * @param list セットする list
	 */
	public void setList(ArrayList<CatalogDTO> list) {
		this.list = list;
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

	public Map<String, Object> getSession() {
		return session;
	}

}