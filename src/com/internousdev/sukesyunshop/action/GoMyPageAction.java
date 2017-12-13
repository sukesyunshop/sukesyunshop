package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.GoMyPageDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.dto.UserInfoDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class GoMyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<CategoryDTO> cateList;
	public UserInfoDTO dto;

	public String execute(){
		dto =new UserInfoDTO();
		String userId = session.get(SessionName.getUserId()).toString();

		try{
			GoMyPageDAO dao =new GoMyPageDAO();
			dto=dao.GoMyPageList(userId);

			SearchDAO searchDAO = new SearchDAO();
			setCateList(searchDAO.getCategory());
			session.put(SessionName.getCategoryList(), getCateList());

			return SUCCESS;
		}catch (SQLException e){
			e.printStackTrace();
			return ERROR;
		}
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

public ArrayList<CategoryDTO> getCateList() {
	return cateList;
}

public void setCateList(ArrayList<CategoryDTO> cateList) {
	this.cateList = cateList;
}

/**
 * @return dto
 */
public UserInfoDTO getDto() {
	return dto;
}

/**
 * @param dto セットする dto
 */
public void setDto(UserInfoDTO dto) {
	this.dto = dto;
}
}