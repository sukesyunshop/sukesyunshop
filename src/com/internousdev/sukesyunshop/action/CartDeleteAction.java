package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.CartDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteAction extends ActionSupport implements SessionAware{

	private CartDAO cartDAO;
	public Map<String, Object> session;
	private int productId;
	private ArrayList<CategoryDTO> cateList;
	public String result = ERROR;

	public String execute(){
		cartDAO = new CartDAO();
		String userId;
		boolean loginFlag = session.get(SessionName.getLoginFlag()).equals(SessionName.getTrue());
		if(loginFlag){
			userId = session.get(SessionName.getUserId()).toString();
		}else{
			userId = session.get(SessionName.getTempUserId()).toString();
		}

		try{
			cartDAO.deleteCart(userId, productId, loginFlag);
			SearchDAO searchDAO = new SearchDAO();
			setCateList(searchDAO.getCategory());
			session.put(SessionName.getCategoryList(), getCateList());
			result = SUCCESS;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;

	}



	public CartDAO getCartDAO() {
		return cartDAO;
	}
	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ArrayList<CategoryDTO> getCateList() {
		return cateList;
	}



	public void setCateList(ArrayList<CategoryDTO> cateList) {
		this.cateList = cateList;
	}



	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}


