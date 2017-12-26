package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	private String sexString;
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
	private ArrayList<CategoryDTO> categoryList;

	// 各機能が外部クラスに存在しているのでインスタンス化

	public Validation validation = new Validation();

	public DestinationDAO destDAO = new DestinationDAO();

	public DestinationDTO destDTO = new DestinationDTO();

	/*------実行メソッド-------*/
	public String execute() {
		String result = SUCCESS;

		/**
		 * ブラウザバックチェック
		 * @param DestinationDTO
		 */
		List<DestinationDTO> destDTOList = new ArrayList<DestinationDTO>();
		if(destDTOList.size() == 0){
			return ERROR;
		}

		/**
		 * エラーチェッカー
		 */
		boolean errorChecker = false;
		SearchDAO searchDAO = new SearchDAO();

		try {
			setCategoryList(searchDAO.getCategory());
			System.out.println(categoryList.get(1));
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}

		/*------- 姓のエラー処理 ------*/
		if (validation.emptyValid(familyName)) {
			familyMessage = "姓が未入力です";
			errorChecker = true;
		}

		else if (validation.overUnderValid(familyName, 1, 16)) {
			familyMessage = "姓は1文字以上16文字以下で入力してください。";
			errorChecker = true;
		}

		else if (validation.hiraganaValid(familyName) && validation.harfEnglishValied(familyName)
				&& validation.kanjiValid(familyName)) {
			familyMessage = "姓は半角英語または漢字またはひらがなで入力してください";
			errorChecker = true;
		}

		/*------- 名のエラー処理 ------*/
		if (validation.emptyValid(firstName)) {
			firstMessage = "名が未入力です";
			errorChecker = true;
		}

		else if (validation.overUnderValid(firstName, 1, 16)) {
			firstMessage = "名は1文字以上16文字以下で入力してください。";
			errorChecker = true;
		}

		else if (validation.harfEnglishValied(firstName) && validation.kanjiValid(firstName)
				&& validation.hiraganaValid(firstName)) {
			firstMessage = "名は半角英語または漢字またはひらがなで入力してください";
			errorChecker = true;
		}

		/*------- 姓ふりがなのエラー処理 ------*/
		if (validation.emptyValid(familyNameKana)) {
			familyKanaMessage = "姓ふりがなが未入力です";
			errorChecker = true;
		}

		else if (validation.overUnderValid(familyNameKana, 1, 16)) {
			familyKanaMessage = "姓ふりがなは1文字以上16文字以下で入力してください。";
			errorChecker = true;
		}

		else if (validation.hiraganaValid(familyNameKana)) {
			familyKanaMessage = "姓ふりがなはひらがなで入力してください";
			errorChecker = true;

		}

		/*------- 名ふりがなのエラー処理 ------*/
		if (validation.emptyValid(firstNameKana)) {
			firstKanaMessage = "名ふりがなが未入力です";
			errorChecker = true;
		}

		else if (validation.overUnderValid(firstNameKana, 1, 16)) {
			firstKanaMessage = "名ふりがなは1文字以上16文字以下で入力してください。";
			errorChecker = true;
		}

		else if (validation.hiraganaValid(firstNameKana)) {
			firstKanaMessage = "名ふりがなはひらがなで入力してください";
			errorChecker = true;
		}

		/*------- 性別選択 -------*/
		if (sex == 0) {
			sexString = "男性";
		}

		else if (sex == 1) {
			sexString = "女性";

		} else {
			errorChecker = true;
		}

		/*------- メールアドレスのエラー処理 ------*/
		if (validation.emptyValid(email)) {

			emailMessage = "メールアドレスが未入力です";
			errorChecker = true;

		} else if (validation.overUnderValid(email, 18, 32)) {

			emailMessage = "メールアドレスは18文字以上32文字以下で入力してください。";
			errorChecker = true;

		} else if (validation.emailAddressValid(email)) {

			emailMessage = "メールアドレスは半角英数字・半角記号で入力してください";
			errorChecker = true;
		}

		/*------- 電話番号のエラー処理 ------*/
		if (validation.emptyValid(telNumber)) {
			telNumberMessage = "電話番号が未入力です";
			errorChecker = true;

		} else if (validation.overUnderValid(telNumber, 11, 13)) {

			telNumberMessage = "電話番号は11文字以上13文字以下で入力してください。";
			errorChecker = true;
		} else if (validation.harfEngNumValied(telNumber)) {

			telNumberMessage = "電話番号は半角数字で入力してください";
			errorChecker = true;
		}

		/*------- 住所のエラー処理 ------*/
		/*if (validation.emptyValid(userAddress)) {
			addressMessage = "住所が未入力です";
			errorChecker = true;
		}
		else if (validation.overUnderValid(userAddress, 15, 50)) {
			addressMessage = "住所は15文字以上50文字以下で入力してください。";
			errorChecker = true;
		}
		else if (!(validation.harfEnglishValied(userAddress) && validation.hiraganaValid(userAddress))) {
			addressMessage = "住所は半角英数字漢字または半角記号または全角カタカナで入力してください";
			errorChecker = true;
		}*/

		/**
		 * エラー検知
		 */
		if(errorChecker == true){
			result = ERROR;
		}

		return result;

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

	public String getSexString() {
		return sexString;
	}

	public void setSexString(String sexString) {
		this.sexString = sexString;
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

	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @return categoryList
	 */
	public ArrayList<CategoryDTO> getCategoryList() {
		return categoryList;
	}

	/**
	 * @param categoryList セットする categoryList
	 */
	public void setCategoryList(ArrayList<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}

	/**
	 * @return validation
	 */
	public Validation getValidation() {
		return validation;
	}

	/**
	 * @param validation セットする validation
	 */
	public void setValidation(Validation validation) {
		this.validation = validation;
	}

	/**
	 * @return destDAO
	 */
	public DestinationDAO getDestDAO() {
		return destDAO;
	}

	/**
	 * @param destDAO セットする destDAO
	 */
	public void setDestDAO(DestinationDAO destDAO) {
		this.destDAO = destDAO;
	}

	/**
	 * @return destDTO
	 */
	public DestinationDTO getDestDTO() {
		return destDTO;
	}

	/**
	 * @param destDTO セットする destDTO
	 */
	public void setDestDTO(DestinationDTO destDTO) {
		this.destDTO = destDTO;
	}

}
