package com.internousdev.sukesyunshop.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.CompletePasswordDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CompletePasswordAction extends ActionSupport implements SessionAware {

		private String loginPassword;

		private String loginId;
		public Map<String,Object> session;

		private CompletePasswordDAO completePasswordDAO = new CompletePasswordDAO();



		public String execute(){
			if(completePasswordDAO.updatePassword(loginPassword,loginId)){
				return SUCCESS;
			}
				return ERROR;
		}

		public String getLoginPassword(){
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

		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
}
