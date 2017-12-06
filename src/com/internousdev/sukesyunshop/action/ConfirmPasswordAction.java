package com.internousdev.sukesyunshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.ConfirmPasswordDAO;
import com.internousdev.sukesyunshop.dto.ConfirmPasswordDTO;
import com.internousdev.sukesyunshop.util.Validation;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmPasswordAction extends ActionSupport implements SessionAware {

	private String loginId;

	private String loginPassword;

	private String confirmPassword;

	public Map<String,Object> session;

	private String errorMessage;

	public Validation validation = new Validation();

	public ConfirmPasswordDAO confirmPasswordDAO=new ConfirmPasswordDAO();

	public ConfirmPasswordDTO confirmPasswordDTO=new ConfirmPasswordDTO();

	public String execute(){
		if(!confirmPasswordDAO.getLoginId(loginId)){
			errorMessage="IDが存在しませんでした";
			return ERROR;
		}
		if(validation.emptyValid(loginPassword)){
			errorMessage="";
		}

		if(loginPassword.equals(confirmPassword)){
			session.put("loginPassword", loginPassword) ;
			session.put("confirmPassword", confirmPassword);
			return SUCCESS;
		}else{
			setErrorMessage("パスワードが一致していません");

		return ERROR;
	}
}

		public String getLoginPassword() {
			return loginPassword;
		}

		public void setLoginPassword(String loginPassword) {
			this.loginPassword = loginPassword;
		}



		public Map<String, Object> getSession() {
			return session;
		}

		@Override
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}

		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
	}


