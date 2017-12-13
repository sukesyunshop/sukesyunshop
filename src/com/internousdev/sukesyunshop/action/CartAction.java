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

	private int productId;
	public Map<String, Object> session;
	private CartDAO cartDAO;
	private ArrayList<CartDTO> cartList;
	private ArrayList<CategoryDTO> cateList;

private String result = ERROR;
	public String execute(){

		cartDAO = new CartDAO();

		String userId;
		boolean loginFlag = session.get(SessionName.getLoginFlag()).equals(SessionName.getTrue());
		if(loginFlag){
			userId	 = session.get(SessionName.getUserId()).toString();
		}else{
			userId = session.get(SessionName.getTempUserId()).toString();
		}
		try{
			if(productId != 0){
				cartDAO.addCart(userId, productId, loginFlag);
			}
			cartList = cartDAO.getCartList(userId,loginFlag);


			SearchDAO searchDAO = new SearchDAO();
			setCateList(searchDAO.getCategory());

			result = SUCCESS;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
		}



		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}

		public Map<String, Object> getSession() {
			return session;
		}
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}

		public CartDAO getCartDAO() {
			return cartDAO;
		}
		public void setCartDAO(CartDAO cartDAO) {
			this.cartDAO = cartDAO;
		}

		public ArrayList<CartDTO> getCartList() {
			return cartList;
		}
		public void setCartList(ArrayList<CartDTO> cartList) {
			this.cartList = cartList;
		}



		public ArrayList<CategoryDTO> getCateList() {
			return cateList;
		}



		public void setCateList(ArrayList<CategoryDTO> cateList) {
			this.cateList = cateList;
		}


}
