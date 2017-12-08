package com.internousdev.sukesyunshop.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.ResetPasswordDAO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class CompletePasswordAction extends ActionSupport implements SessionAware {

		/*新規パスワード*/
		private String loginPassword;

		/*ログインID*/
		private String loginId;

		public Map<String,Object> session;

		private ResetPasswordDAO resetPasswordDAO = new ResetPasswordDAO();


		/*------実行メソッド-----*/
		public String execute(){
			if(resetPasswordDAO.updatePassword(loginPassword,loginId)){
				session.put(SessionName.getUserPassword(), loginPassword);
				return SUCCESS;
			}
				return ERROR;
		}

		/*新規パスワードのゲッターセッター*/
		public String getLoginPassword(){
			return loginPassword;
		}
		public void setLoginPassword(String loginPassword) {
			this.loginPassword = loginPassword;
		}

		/*セッション*/
		public Map<String, Object> getSession() {
			return session;
		}
		@Override
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}

		/*ログインIDのゲッターセッター*/
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
}
