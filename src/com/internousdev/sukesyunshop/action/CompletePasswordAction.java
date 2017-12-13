package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.ResetPasswordDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.dto.ResetPasswordDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CompletePasswordAction extends ActionSupport implements SessionAware {

		/*新規パスワード*/
		private String loginPassword;

		/*ログインID*/
		private String loginId;

		/*ログインID入力エラーメッセージ*/
		private String userIdMessage;

		/*検索バー用のカテゴリーのリスト*/
		private ArrayList<CategoryDTO> cateList;

		public Map<String,Object> session;

		private ResetPasswordDAO resetPasswordDAO = new ResetPasswordDAO();

		private ResetPasswordDTO resetPasswordDTO = new ResetPasswordDTO();



		/*------実行メソッド-----*/
		public String execute(){

			try{
				SearchDAO searchDAO = new SearchDAO();
				setCateList(searchDAO.getCategory());
			}catch(SQLException e){
				e.printStackTrace();
			}


			loginPassword=session.get("loginPassword").toString();
			loginId=session.get("loginId").toString();

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

		/*ログインIDのゲッターセッター*/
		public String getLoginId() {
				return loginId;
			}
		public void setLoginId(String loginId) {
				this.loginId = loginId;
			}

		public ArrayList<CategoryDTO> getCateList() {
			return cateList;
		}


		public void setCateList(ArrayList<CategoryDTO> cateList) {
			this.cateList = cateList;
		}


		/*セッション*/
		public Map<String, Object> getSession() {
				return session;
			}
		@Override
		public void setSession(Map<String, Object> session) {
				this.session = session;
			}

		/*ログインID入力失敗のエラーメッセージ*/
		public String getUserIdMessage() {
				return userIdMessage;
			}

		public void setUserIdMessage(String userIdMessage) {
				this.userIdMessage = userIdMessage;
			}

		public ResetPasswordDTO getResetPasswordDTO() {
			return resetPasswordDTO;
		}

		public void setResetPasswordDTO(ResetPasswordDTO resetPasswordDTO) {
			this.resetPasswordDTO = resetPasswordDTO;
		}
	}
