package com.internousdev.sukesyunshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.CatalogDAO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailAction extends ActionSupport implements SessionAware {

	public int productId;
	public CatalogDTO dto;
	public Map<String, Object> session;

	public String execute(){
		System.out.println("hoge");
		String result = ERROR;
		CatalogDAO dao = new CatalogDAO();
		try{
			System.out.println(productId);
			dto=dao.getItem(productId);
			result=SUCCESS;
		}catch(NumberFormatException e){
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
}


