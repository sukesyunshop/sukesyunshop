package com.internousdev.sukesyunshop.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.play.dao.CatalogDAO;
import com.internousdev.play.dto.CatalogDTO;
import com.opensymphony.xwork2.ActionSupport;


public class CatalogAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private CatalogDAO catalogDAO = new CatalogDAO();

	private ArrayList<CatalogDTO> list;


	private String result = ERROR;

	public String execute(){

		try{
			list=catalogDAO.getCatalogList();

			result = SUCCESS;
		} catch (NumberFormatException e){
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

	public ArrayList<CatalogDTO> getList() {
		return list;
	}

	public void setList(ArrayList<CatalogDTO> list) {
		this.list = list;
	}

}