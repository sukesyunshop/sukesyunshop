package com.internousdev.sukesyunshop.action;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.CatalogDAO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailAction extends ActionSupport implements SessionAware {

	public int productId;

	public CatalogDTO dto;

	private CatalogDAO dao = new CatalogDAO();

	public Map<String, Object> session;

	public String execute(){

		String result = ERROR;
		try{
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


