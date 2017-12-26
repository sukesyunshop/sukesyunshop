package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.CatalogDAO;
import com.internousdev.sukesyunshop.dao.SearchDAO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailAction extends ActionSupport implements SessionAware {

	/*
	 * 戻るに対応するため検索テキストを保管する変数
	 */
	private String searchText;

	/*
	 * 戻るに対応するため検索カテゴリを保管する変数
	 */
	private int categoryId;

	/*
	 * product_infoのproduct_idを保管する
	 */
	private int productId;

	/*
	 * 商品詳細に表示するdtoを保管する
	 */
	private CatalogDTO catalogDTO;

	/*
	 * セッション情報を格納するマップ
	 */
	private Map<String, Object> session;

	/*
	 * 商品情報を表示した際同じカテゴリの商品を4件表示するためのリスト
	 */
	private ArrayList<CatalogDTO> miniList;

	/*
	 * カテゴリ一覧のリスト
	 */
	private ArrayList<CategoryDTO> categoryList;

	public String execute() {
		String result = SUCCESS;

		try {
			CatalogDAO catalogDAO = new CatalogDAO();
			SearchDAO searchDAO = new SearchDAO();

			setCatalogDTO(catalogDAO.getItem(productId));
			setMiniList(catalogDAO.miniList(catalogDTO.getCategoryId(), catalogDTO.getId()));
			setCategoryList(searchDAO.getCategory());

		} catch(SQLException e) {
			e.printStackTrace();
			result = ERROR;
		}
		return result;

	}

	/**
	 * @return productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId セットする productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return catalogDTO
	 */
	public CatalogDTO getCatalogDTO() {
		return catalogDTO;
	}

	/**
	 * @param catalogDTO セットする catalogDTO
	 */
	public void setCatalogDTO(CatalogDTO catalogDTO) {
		this.catalogDTO = catalogDTO;
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
	 * @return miniList
	 */
	public ArrayList<CatalogDTO> getMiniList() {
		return miniList;
	}

	/**
	 * @param miniList セットする miniList
	 */
	public void setMiniList(ArrayList<CatalogDTO> miniList) {
		this.miniList = miniList;
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
	 * @return searchText
	 */
	public String getSearchText() {
		return searchText;
	}

	/**
	 * @param searchText セットする searchText
	 */
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	/**
	 * @return categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId セットする categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


}