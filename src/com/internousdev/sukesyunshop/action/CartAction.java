package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.CartDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CartDTO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	/*
	 * 挿入するproduct_infoのproduct_idを保管
	 */
	private int productId;

	/*
	 * セッション情報を格納するマップ
	 */
	public Map<String, Object> session;

	/*
	 * 挿入後のカート情報を保管する
	 */
	private ArrayList<CartDTO> cartList;

	/*
	 * カテゴリ一覧のリスト
	 */
	private ArrayList<CategoryDTO> categoryList;

	public String execute(){
		String result = SUCCESS;
		CartDAO cartDAO = new CartDAO();
		SearchDAO searchDAO = new SearchDAO();
		String userId;
		boolean loginFlag = session.get(SessionName.getLoginFlag()).equals(SessionName.getTrue());

		if(loginFlag) {
			userId = session.get(SessionName.getUserId()).toString();
		} else {
			userId = session.get(SessionName.getTempUserId()).toString();
		}

		try {

			if(productId != 0 && !cartDAO.searchCart(userId, productId, loginFlag)) {
				cartDAO.addCart(userId, productId, loginFlag);
			}

			setCartList(cartDAO.getCartList(userId,loginFlag));
			setCategoryList(searchDAO.getCategory());
		}catch(SQLException e){
			e.printStackTrace();
			result = ERROR;
		}
		return result;
	}

	/**
	 * @return productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId セットする productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
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
	 * @return cartList
	 */
	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * @param cartList セットする cartList
	 */
	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
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

}
