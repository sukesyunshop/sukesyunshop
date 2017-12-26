package com.internousdev.sukesyunshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.LoginAuthDAO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.internousdev.sukesyunshop.util.Validation;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/*
	 * ログイン時のIDを保管する
	 */
	private String userId;

	/*
	 * ログイン時のpasswordを保管する
	 */
	private String password;

	/*
	 * ログイン時にIDを保管するかの可否
	 */
	private String saveId="";

	/*
	 * セッション情報を格納するマップ
	 */
	private Map<String, Object> session;

	/*
	 * IDが間違っていた場合にエラーメッセージを入れる
	 */
	private String userIdMessage;

	/*
	 * Passwordが間違っていた場合にエラーメッセージを入れる
	 */
	private String passwordMessage;

	/*
	 * validationを行うクラス
	 */
	private Validation valid = new Validation();

	public String execute(){
		String result = SUCCESS;
		userIdMessage = validation(userId, "ユーザーID", 1, 8);
		passwordMessage = validation(password, "パスワード", 1, 16);

		if(!userIdMessage.equals("") || !passwordMessage.equals("")) {
			result = "back";
		} else {

			LoginAuthDAO loginDAO = new LoginAuthDAO();

			try{

				if(loginDAO.login(userId, password)) {
					session.put(SessionName.getUserId(), userId);
					session.put(SessionName.getUserPassword(), password);
					session.put(SessionName.getLoginFlag(), SessionName.getTrue());

					if(saveId.equals("true")) {
						session.put(SessionName.getSaveId(), SessionName.getTrue());
					} else {
						session.put(SessionName.getSaveId(), SessionName.getFalse());
					}

					String tempUserId = session.get(SessionName.getTempUserId()).toString();
					loginDAO.switchId(userId, tempUserId);

					if(session.get(SessionName.getBuying()) == null) {
						session.remove(SessionName.getBuying());
						result = SUCCESS;
					} else {
						session.remove(SessionName.getBuying());
						result = "buy";
					}

				} else {
					passwordMessage = "入力されたパスワードが異なります。";
					result = "back";
				}

			} catch(Exception e) {
				e.printStackTrace();
				result = ERROR;
			}
		}
		return result;
	}

	private String validation(String target, String targetName, int min, int max) {

		if(valid.emptyValid(target)) {
			return targetName+"を入力してください";
		} else if(valid.overUnderValid(target, min, max)) {
			return targetName+"は"+min+"文字以上"+max+"文字以下で入力してください。";
		} else if (valid.harfEngNumValied(target)) {
			return targetName+"は半角英数で入力してください";
		}

		return "";
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return saveId
	 */
	public String getSaveId() {
		return saveId;
	}

	/**
	 * @param saveId セットする saveId
	 */
	public void setSaveId(String saveId) {
		this.saveId = saveId;
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
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return userIdMessage
	 */
	public String getUserIdMessage() {
		return userIdMessage;
	}

	/**
	 * @param userIdMessage セットする userIdMessage
	 */
	public void setUserIdMessage(String userIdMessage) {
		this.userIdMessage = userIdMessage;
	}

	/**
	 * @return passwordMessage
	 */
	public String getPasswordMessage() {
		return passwordMessage;
	}

	/**
	 * @param passwordMessage セットする passwordMessage
	 */
	public void setPasswordMessage(String passwordMessage) {
		this.passwordMessage = passwordMessage;
	}

	/**
	 * @return valid
	 */
	public Validation getValid() {
		return valid;
	}

	/**
	 * @param valid セットする valid
	 */
	public void setValid(Validation valid) {
		this.valid = valid;
	}


}
