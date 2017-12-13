package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.ItemHistoryDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.dto.ItemHistoryDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class ItemHistoryAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	public ArrayList<ItemHistoryDTO>  list ;
	private ArrayList<CategoryDTO> cateList;



	/**
	 * 商品購入情報取得メソッド
	 *
	 * @author internous
	 */
	public String execute() {
		ItemHistoryDAO dao =new ItemHistoryDAO ();
		String userId = session.get(SessionName.getUserId()).toString();

		try {
			list =dao.getItemHistoryList(userId);

			SearchDAO searchDAO = new SearchDAO();
			setCateList(searchDAO.getCategory());

			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * @return list
	 */
	public ArrayList<ItemHistoryDTO> getList() {
		return list;
	}

	/**
	 * @param list セットする list
	 */
	public void setList(ArrayList<ItemHistoryDTO> list) {
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
}