package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.DestinationDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.dto.DestinationDTO;
import com.internousdev.sukesyunshop.util.Validation;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmDestAction extends ActionSupport implements SessionAware {

	// 宛先情報変数
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private int sex;
	private String sexStr;
	private String email;
	private String telNumber;
	private String userAddress;

	// 各入力のエラーメッセージ

	private String familyMessage;
	private String firstMessage;
	private String familyKanaMessage;
	private String firstKanaMessage;
	private String emailMessage;
	private String telNumberMessage;
	private String addressMessage;

	// 宛先情報を格納
	public Map<String, Object> session;
	private ArrayList<CategoryDTO> cateList;

	// 各機能が外部クラスに存在しているのでインスタンス化

	public Validation validation = new Validation();

	public DestinationDAO destDAO = new DestinationDAO();

	public DestinationDTO destDTO = new DestinationDTO();

	/*------実行メソッド-------*/
	public String execute() {
		SearchDAO searchDAO = new SearchDAO();
		try {
			setCateList(searchDAO.getCategory());
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}

		/*------- 姓のエラー処理 ------*/
		if (validation.emptyValid(familyName)) {
			familyMessage = "姓が未入力です";
			return ERROR;
		}
		if (validation.overUnderValid(familyName, 1, 16)) {
			familyMessage = "姓は1文字以上16文字以下で入力してください。";
			return ERROR;
		}
		if (validation.hiraganaValid(familyName) && validation.harfEnglishValied(familyName)
				&& validation.kanjiValid(familyName)) {
			familyMessage = "姓は半角英語または漢字またはひらがなで入力してください";
			return ERROR;
		}

		/*------- 名のエラー処理 ------*/
		if (validation.emptyValid(firstName)) {
			firstMessage = "名が未入力です";
			return ERROR;
		}
		if (validation.overUnderValid(firstName, 1, 16)) {
			firstMessage = "名は1文字以上16文字以下で入力してください。";
		}
		if (validation.harfEnglishValied(firstName) && validation.kanjiValid(firstName)
				&& validation.hiraganaValid(firstName)) {
			firstMessage = "名は半角英語または漢字またはひらがなで入力してください";
			return ERROR;
		}

		/*------- 姓ふりがなのエラー処理 ------*/
		if (validation.emptyValid(familyNameKana)) {
			familyKanaMessage = "姓ふりがなが未入力です";
			return ERROR;
		}
		if (validation.overUnderValid(familyNameKana, 1, 16)) {
			familyKanaMessage = "姓ふりがなは1文字以上16文字以下で入力してください。";
			return ERROR;
		}
		if (validation.hiraganaValid(familyNameKana)) {
			familyKanaMessage = "姓ふりがなはひらがなで入力してください";
			return ERROR;

		}

		/*------- 名ふりがなのエラー処理 ------*/
		if (validation.emptyValid(firstNameKana)) {
			firstKanaMessage = "名ふりがなが未入力です";
			return ERROR;
		}
		if (validation.overUnderValid(firstNameKana, 1, 16)) {
			firstKanaMessage = "名ふりがなは1文字以上16文字以下で入力してください。";
			return ERROR;
		}
		if (validation.hiraganaValid(firstNameKana)) {
			firstKanaMessage = "名ふりがなはひらがなで入力してください";
			return ERROR;
		}

		/*------- 性別選択 -------*/
		if (sex == 0) {
			sexStr = "男性";
		}

		if (sex == 1) {
			sexStr = "女性";
		}

		/*------- 住所のエラー処理 ------*/
		if (validation.emptyValid(userAddress)) {
			addressMessage = "住所が未入力です";
			return ERROR;
		}
		if (validation.overUnderValid(userAddress, 15, 50)) {
			addressMessage = "住所は15文字以上50文字以下で入力してください。";
			return ERROR;
		}
		if (!(validation.harfEnglishValied(userAddress) && validation.hiraganaValid(userAddress))) {
			addressMessage = "住所は半角英数字漢字または半角記号または全角カタカナで入力してください";
			return ERROR;
		}

		/*------- 電話番号のエラー処理 ------*/
		if (validation.emptyValid(telNumber)) {
			telNumberMessage = "電話番号が未入力です";
			return ERROR;
		}
		if (validation.overUnderValid(telNumber, 11, 13)) {

			telNumberMessage = "電話番号は11文字以上13文字以下で入力してください。";
			return ERROR;
		}
		if (validation.harfEngNumValied(telNumber)) {

			telNumberMessage = "電話番号は半角数字で入力してください";
			return ERROR;
		}

		/*------- メールアドレスのエラー処理 ------*/
		if (validation.emptyValid(email)) {

			emailMessage = "メールアドレスが未入力です";
			return ERROR;
		}
		if (validation.overUnderValid(email, 18, 32)) {

			emailMessage = "メールアドレスは18文字以上32文字以下で入力してください。";
			return ERROR;
		}
		if (validation.emailAddressValid(email)) {

			emailMessage = "メールアドレスは半角英数字・半角記号で入力してください";
			return ERROR;
		}
		/*-------成功処理 処理 ------*/
		return SUCCESS;

	}

	/*------ 宛先情報のゲッターセッター ------*/
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getSexStr() {
		return sexStr;
	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/*------ エラーメッセージのゲッターセッター ------*/
	public String getFamilyMessage() {
		return familyMessage;
	}

	public void setFamilyMessage(String familyMessage) {
		this.familyMessage = familyMessage;
	}

	public String getFirstMessage() {
		return firstMessage;
	}

	public void setFirstMessage(String firstMessage) {
		this.firstMessage = firstMessage;
	}

	public String getFamilyKanaMessage() {
		return familyKanaMessage;
	}

	public void setFamilyKanaMessage(String familyKanaMessage) {
		this.familyKanaMessage = familyKanaMessage;
	}

	public String getFirstKanaMessage() {
		return firstKanaMessage;
	}

	public void setFirstKanaMessage(String firstKanaMessage) {
		this.firstKanaMessage = firstKanaMessage;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public String getTelNumberMessage() {
		return telNumberMessage;
	}

	public void setTelNumberMessage(String telNumberMessage) {
		this.telNumberMessage = telNumberMessage;
	}

	public String getAddressMessage() {
		return addressMessage;
	}

	public void setAddressMessage(String addressMessage) {
		this.addressMessage = addressMessage;
	}

	/* セッションのセッター */

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CategoryDTO> getCateList() {
		return cateList;
	}

	public void setCateList(ArrayList<CategoryDTO> cateList) {
		this.cateList = cateList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
