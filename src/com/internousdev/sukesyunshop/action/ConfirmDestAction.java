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

	//宛先情報変数
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;

	//各入力のエラーメッセージ

	private String familyMessage;
	private String firstMessage;
	private String familyKanaMessage;
	private String firstKanaMessage;
	private String emailMessage;
	private String telNumberMessage;
	private String addressMessage;

	//宛先情報を格納
	private Map<String, Object> session;

	//各機能が外部クラスに存在しているのでインスタンス化

	public Validation validation = new Validation();

	public DestinationDAO destDAO = new DestinationDAO();

	public List<DestinationDTO>destDTOList = new ArrayList<DestinationDTO>();


	/*------実行メソッド-------*/
	public String execute() {
		//各エラー処理
		if(validation.emptyValid(familyName)) {
			familyMessage = "姓が未入力です";
			return ERROR;
		}else if(validation.overUnderValid(familyName,1,16)) {
			familyMessage = "姓は1文字以上16文字以下で入力してください。";
			return ERROR;
		}


	}



}
