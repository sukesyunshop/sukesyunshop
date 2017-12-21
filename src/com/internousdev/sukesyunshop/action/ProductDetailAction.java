package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.CatalogDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailAction extends ActionSupport implements SessionAware {

	public int productId;
	public CatalogDTO dto;
	public Map<String, Object> session;
	public ArrayList<CatalogDTO> miniList;
	public ArrayList<CategoryDTO> cateList;
	public CatalogDAO catalogdao = new CatalogDAO();


	private String result = ERROR;
	public String execute(){

		try{
			dto=catalogdao.getItem(productId);
			miniList=catalogdao.miniList(dto.getCategoryId(), dto.getId());

			SearchDAO dao = new SearchDAO();
			cateList = dao.getCategory();

			result=SUCCESS;
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

		public Map<String,Object> getSession () {
			return session;
		}
		public void setSession(Map<String, Object> arg0) {
				this.session = arg0;
		}


		public ArrayList<CatalogDTO> getMiniList() {
			return miniList;
		}


		public void setMiniList(ArrayList<CatalogDTO> miniList) {
			this.miniList = miniList;
		}

}