package com.internousdev.sukesyunshop.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.DestinationDAO;
import com.internousdev.sukesyunshop.dto.DestinationDTO;
import com.internousdev.sukesyunshop.util.Validation;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmDestAction extends ActionSupport implements SessionAware {

	// 宛先情報変数
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
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
	private Map<String, Object> session;

	// 各機能が外部クラスに存在しているのでインスタンス化

	public Validation validation = new Validation();

	public DestinationDAO destDAO = new DestinationDAO();

	public List<DestinationDTO> destDTOList = new ArrayList<DestinationDTO>();

	/*------実行メソッド-------*/
	public String execute() {

		/*------- 姓のエラー処理 ------*/
		if (validation.emptyValid(familyName)) {
			familyMessage = "姓が未入力です";
			return ERROR;
		} else if (validation.overUnderValid(familyName, 1, 16)) {
			familyMessage = "姓は1文字以上16文字以下で入力してください。";
			return ERROR;
		} else if (validation.harfMarkValied(familyName) && validation.katakanaValid(familyName)
				&& validation.harfEnglishValied(familyName)) {
			familyMessage = "姓は半角英語or漢字orひらがなで入力してください";
			return ERROR;
		}

		/*------- 名のエラー処理 ------*/
		else if (validation.emptyValid(firstName)) {
			firstMessage = "名が未入力です";
			return ERROR;
		} else if (validation.overUnderValid(firstName, 1, 16)) {
			firstMessage = "名は1文字以上16文字以下で入力してください。";
		} else if (validation.harfMarkValied(firstName) && validation.katakanaValid(firstName)
				&& validation.harfEnglishValied(firstName)) {
			firstMessage = "名は半角英語or漢字orひらがなで入力してください";
			return ERROR;
		}

		/*------- 姓ふりがなのエラー処理 ------*/
		else if (validation.emptyValid(familyNameKana)) {
			familyKanaMessage = "姓ふりがなが未入力です";
			return ERROR;
		} else if (validation.overUnderValid(familyNameKana, 1, 16)) {
			familyKanaMessage = "姓ふりがなは1文字以上16文字以下で入力してください。";
			return ERROR;
		} else if (validation.harfEngNumValied(familyNameKana) && validation.harfMarkValied(familyNameKana)
				&& validation.katakanaValid(familyNameKana) && validation.kanjiValid(familyNameKana)
				&& validation.harfEnglishValied(familyNameKana)) {
			familyKanaMessage = "姓ふりがなはひらがなで入力してください";
			return ERROR;

		}

		/*------- 名ふりがなのエラー処理 ------*/
		else if (validation.emptyValid(firstNameKana)) {
			firstKanaMessage = "姓ふりがなが未入力です";
			return ERROR;
		} else if (validation.overUnderValid(firstNameKana, 1, 16)) {
			firstKanaMessage = "姓ふりがなは1文字以上16文字以下で入力してください。";
			return ERROR;
		} else if (validation.harfEngNumValied(firstNameKana) && validation.harfMarkValied(firstNameKana)
				&& validation.katakanaValid(firstNameKana) && validation.kanjiValid(firstNameKana)
				&& validation.harfEnglishValied(firstNameKana)) {
			firstKanaMessage = "姓ふりがなはひらがなで入力してください";
			return ERROR;
		}

		/*------- 住所のエラー処理 ------*/
		else if (validation.emptyValid(userAddress)) {
			addressMessage = "住所が未入力です";
			return ERROR;
		} else if (validation.overUnderValid(userAddress, 15, 50)) {
			addressMessage = "住所は15文字以上50文字以下で入力してください。";
			return ERROR;
		} else if (validation.harfEnglishValied(userAddress) && validation.hiraganaValid(userAddress)) {
			addressMessage = "住所はひらがなで入力してください";
			return ERROR;
		}

		/*------- 電話番号のエラー処理 ------*/
		else if (validation.emptyValid(telNumber)) {
			addressMessage = "電話番号が未入力です";
			return ERROR;
		} else if (validation.overUnderValid(telNumber, 11, 13)) {
			addressMessage = "電話番号は11文字以上13文字以下で入力してください。";
			return ERROR;
		} else if (validation.harfEnglishValied(telNumber) && validation.hiraganaValid(telNumber)) {
			addressMessage = "住所はひらがなで入力してください";
			return ERROR;
		}

		/*------- メールアドレスのエラー処理 ------*/
		else if (validation.emptyValid(email)) {
			addressMessage = "電話番号が未入力です";
			return ERROR;
		} else if (validation.overUnderValid(email, 18, 32)) {
			addressMessage = "電話番号は18文字以上32文字以下で入力してください。";
			return ERROR;
		} else if (validation.harfEnglishValied(email) && validation.hiraganaValid(email)) {
			addressMessage = "住所はひらがなで入力してください";
			return ERROR;
		}
		/*-------成功処理 処理 ------*/
		else {
			return SUCCESS;
		}
		/*-----returnがわかりません。-----*/
		return null;
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
		return familyName;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyName = familyNameKana;
	}

	public String getFirstNamKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
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

	/* セッションのゲッターセッター */
	public Map<String , Object>getSession(){
			return session;
		}
	@Override
	public void setSession(Map<String , Object> session){
			this.session = session;
		}


}
