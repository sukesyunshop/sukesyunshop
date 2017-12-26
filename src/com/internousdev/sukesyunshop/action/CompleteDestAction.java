package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.DestinationDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.dto.DestinationDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class CompleteDestAction extends ActionSupport implements SessionAware {

	// 宛先情報変数
	private String userId;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private int sex;
	private String email;
	private String telNumber;
	private String userAddress;
	public Map<String, Object> session;
	private ArrayList<CategoryDTO> categoryList;

	/*----必要な機能をインスタンス化-----*/
	DestinationDAO destDAO = new DestinationDAO();
	DestinationDTO destDTO = new DestinationDTO();

	/*-----------実行メソッド-----------*/
	public String execute() {
		String result = ERROR;

		userId = session.get(SessionName.getUserId()).toString();

		// HTML側から送られてきた入力値を登録用のDTOへまとめます。

		destDTO = setPrameters(destDTO);

		// 登録処理
		try {
			if(destDAO.destInsert(destDTO) != 0 && destDAO.existDest(destDTO)){
				SearchDAO searchDAO = new SearchDAO();
				setCategoryList(searchDAO.getCategory());
				// 登録判定
				// insertCountが0である場合 => 登録失敗
				// insertCountが1である場合 => 登録成功
				result = SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * JSPから送られてきた宛先情報をDTOに設定します。
	 *
	 * @param destinationDTO
	 * @return destinationDTO
	 */
	private DestinationDTO setPrameters(DestinationDTO destinationDTO) {

		destinationDTO.setUserId(userId);
		destinationDTO.setFamilyName(familyName);
		destinationDTO.setFirstName(firstName);
		destinationDTO.setFirstNameKana(firstNameKana);
		destinationDTO.setFamilyNameKana(familyNameKana);
		destinationDTO.setSex(sex);
		destinationDTO.setEmail(email);
		destinationDTO.setTelNumber(telNumber);
		destinationDTO.setUserAddress(userAddress);
		return destinationDTO;

	}

	/*------ 宛先情報のゲッターセッター ------*/
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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
}
