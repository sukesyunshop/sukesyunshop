package com.internousdev.sukesyunshop.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.ResetPasswordDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CompletePasswordAction extends ActionSupport implements SessionAware {

		/*新規パスワード*/
		private String loginPassword;

		/*ログインID*/
		private String loginId;

		/*ログインID失敗のエラーメッセージ*/
		private String userIdMessage;

		public Map<String,Object> session;

		private ResetPasswordDAO resetPasswordDAO = new ResetPasswordDAO();


		/*------実行メソッド-----*/
		public String execute(){

			/*ログインIDをDBから特定*/
			if(!resetPasswordDAO.getLoginId(loginId)){
				setUserIdMessage("ログインIDが存在しません");
				return "back";
			}

			/*ユーザーIDを元にして新しいパスワードをDBにセットするメソッド*/
			if(resetPasswordDAO.updatePassword(loginPassword,loginId)){
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

		/*ログインID入力失敗のエラーメッセージ*/
		public String getUserIdMessage() {
			return userIdMessage;
		}

		public void setUserIdMessage(String userIdMessage) {
			this.userIdMessage = userIdMessage;
		}
}
