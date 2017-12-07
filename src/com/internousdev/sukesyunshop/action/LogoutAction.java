package com.internousdev.sukesyunshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.LoginAuthDAO;
import com.internousdev.sukesyunshop.dto.UserInfoDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute(){
		LoginAuthDAO dao = new LoginAuthDAO();
		UserInfoDTO dto = (UserInfoDTO) session.get(SessionName.getLoginUserDto());
		dao.logout(dto.getUserId(), dto.getPassword());

		session.clear();

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
