package com.internousdev.sukesyunshop.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.DestinationDAO;
import com.internousdev.sukesyunshop.dto.DestinationDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CompleteDestAction extends ActionSupport implements SessionAware {

	// 宛先情報変数
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;
	private Map<String, Object> session;

	/*----必要な機能をインスタンス化-----*/
	DestinationDAO destDAO = new DestinationDAO();
	List <DestinationDTO> destDTOList = new ArrayList <DestinationDTO>();
	DestinationDTO destDTO = new DestinationDTO();
	/*-----------実行メソッド-----------*/
	public String execute() {
		/*-----分からない-----*/
			destDAO.destInsert(destDTO.setFamilyName(familyName));
			String result = SUCCESS;





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

	/* セッションのゲッターセッター */
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
