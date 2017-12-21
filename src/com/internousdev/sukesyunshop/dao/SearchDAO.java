package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.dto.CategoryDTO;
import com.internousdev.sukesyunshop.util.DBConnector;

public class SearchDAO {

	private DBConnector connector = new DBConnector();
	private Connection connection = connector.getConnection();

	public ArrayList<CatalogDTO> searchCatalog(int category, String searchText, int page) throws SQLException{
		ArrayList<CatalogDTO> list = new ArrayList<>();

		String sql;
		PreparedStatement statement = null;
		String wc = "%";

		if(category == 0 && (searchText == null || searchText.equals(""))){
			sql = ""
				+ "SELECT * "
				+ "FROM product_info "
				+ "INNER JOIN m_category "
				+ "ON product_info.category_id = m_category.category_id "
				+ "LIMIT ?, ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, (page-1)*9);
			statement.setInt(2, 9);
			System.out.println(page+"foo");
		}else if(category == 0){
			sql = ""
					+ "SELECT * "
					+ "FROM product_info "
					+ "INNER JOIN m_category "
					+ "ON product_info.category_id = m_category.category_id "
					+ "WHERE ( product_name LIKE ? "
					+ "OR product_name_kana LIKE ? ) "
					+ "LIMIT ?, ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, wc+searchText+wc);
			statement.setString(2, wc+searchText+wc);
			statement.setInt(3, (page-1)*9);
			statement.setInt(4, 9);
		}else if(searchText == null || searchText.equals("")){
			sql = ""
					+ "SELECT * "
					+ "FROM product_info "
					+ "INNER JOIN m_category "
					+ "ON product_info.category_id = m_category.category_id "
					+ "WHERE product_info.category_id = ? "
					+ "LIMIT ?, ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, category);
			statement.setInt(2, (page-1)*9);
			statement.setInt(3, 9);
		}else{
			sql = ""
					+ "SELECT * "
					+ "FROM product_info "
					+ "INNER JOIN m_category "
					+ "ON product_info.category_id = m_category.category_id "
					+ "WHERE product_info.category_id = ? "
					+ "AND ( product_name LIKE ? "
					+ "OR product_name_kana LIKE ? ) "
					+ "LIMIT ?, ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, category);
			statement.setString(2, wc+searchText+wc);
			statement.setString(3, wc+searchText+wc);
			statement.setInt(4, (page-1)*9);
			statement.setInt(5, 9);
		}

		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()){
			CatalogDTO dto = new CatalogDTO();
			dto.setId(resultSet.getInt("product_info.id"));
			dto.setProductId(resultSet.getInt("product_id"));
			dto.setProductName(resultSet.getString("product_name"));
			dto.setProductNameKana(resultSet.getString("product_name_kana"));
			dto.setProductDescription(resultSet.getString("product_description"));
			dto.setCategoryId(resultSet.getInt("product_info.category_id"));
			dto.setCategoryName(resultSet.getString("category_name"));
			dto.setCategoryDescription(resultSet.getString("category_description"));
			dto.setPrice(resultSet.getInt("price"));
			dto.setImageFilePath(resultSet.getString("image_file_path"));
			dto.setImageFileName(resultSet.getString("image_file_name"));
			dto.setReleaseDate (resultSet.getString("release_date"));
			dto.setReleaseCompany(resultSet.getString("release_company"));
			list.add(dto);
		}

		return list;

	}

	public int getCatalogCount(int category, String searchText, int page) throws SQLException{
		String sql;
		PreparedStatement statement = null;
		String wc = "%";
		if(category == 0 && (searchText == null || searchText.equals(""))){
			sql = ""
					+ "SELECT * "
					+ "FROM product_info ";
			statement = connection.prepareStatement(sql);
		}else if(category == 0){
			sql = ""
					+ "SELECT * "
					+ "FROM product_info "
					+ "WHERE ( product_name LIKE ? "
					+ "OR product_name_kana LIKE ? ) ";
			statement = connection.prepareStatement(sql);
			statement.setString(1, wc+searchText+wc);
			statement.setString(2, wc+searchText+wc);
		}else if(searchText == null || searchText.equals("")){
			sql = ""
					+ "SELECT * "
					+ "FROM product_info "
					+ "WHERE category_id = ? ";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, category);
		}else{
			sql = ""
					+ "SELECT * "
					+ "FROM product_info "
					+ "WHERE category_id = ? "
					+ "AND ( product_name LIKE ? "
					+ "OR product_name_kana LIKE ? ) ";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, category);
			statement.setString(2, wc+searchText+wc);
			statement.setString(3, wc+searchText+wc);
		};

		ResultSet resultSet = statement.executeQuery();
		int counter=0;
		while(resultSet.next()){
			counter++;
		}
		return counter;
	}

	public ArrayList<CategoryDTO> getCategory() throws SQLException{
		ArrayList<CategoryDTO> list = new ArrayList<>();
		String sql = ""
				+ "SELECT * "
				+ "FROM m_category ";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			CategoryDTO dto = new CategoryDTO();
			dto.setCategoryId(resultSet.getInt("category_id"));
			dto.setCategoryName(resultSet.getString("category_name"));
			dto.setCategoryDescription(resultSet.getString("category_description"));
			list.add(dto);
		}
		return list;
	}

	public ArrayList<CatalogDTO> getSaleCatalogList(int[] saleId) throws SQLException{
		ArrayList<CatalogDTO> list = new ArrayList<CatalogDTO>();
		StringBuilder sqlPiece = new StringBuilder();
		if(saleId == null) return list;
		for(int i=1; i <= saleId.length; i++){
			sqlPiece.append("OR product_id = ? ");
		}
		String sql = ""
				+ "SELECT * "
				+ "FROM product_info "
				+ "INNER JOIN m_category "
				+ "ON product_info.category_id = m_category.category_id "
				+ "WHERE false "
				+ sqlPiece.toString();

		PreparedStatement statement = connection.prepareStatement(sql);
		int i=1;
		for(int id : saleId){
			statement.setInt(i++, id);
		}
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()){
			CatalogDTO dto = new CatalogDTO();
			dto.setId(resultSet.getInt("product_info.id"));
			dto.setProductId(resultSet.getInt("product_id"));
			dto.setProductName(resultSet.getString("product_name"));
			dto.setProductNameKana(resultSet.getString("product_name_kana"));
			dto.setProductDescription(resultSet.getString("product_description"));
			dto.setCategoryId(resultSet.getInt("product_info.category_id"));
			dto.setCategoryName(resultSet.getString("category_name"));
			dto.setCategoryDescription(resultSet.getString("category_description"));
			dto.setPrice(resultSet.getInt("price"));
			dto.setImageFilePath(resultSet.getString("image_file_path"));
			dto.setImageFileName(resultSet.getString("image_file_name"));
			dto.setReleaseDate (resultSet.getString("release_date"));
			dto.setReleaseCompany(resultSet.getString("release_company"));
			list.add(dto);
		}

		return list;
	}

	public ArrayList<CatalogDTO> getNewArriveList() throws SQLException{
		ArrayList<CatalogDTO> list = new ArrayList<>();
		String sql = ""
				+ "SELECT * "
				+ "FROM product_info "
				+ "INNER JOIN m_category "
				+ "ON product_info.category_id = m_category.category_id "
				+ "ORDER BY release_date DESC "
				+ "LIMIT 5 ";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			CatalogDTO dto = new CatalogDTO();
			dto.setId(resultSet.getInt("product_info.id"));
			dto.setProductId(resultSet.getInt("product_id"));
			dto.setProductName(resultSet.getString("product_name"));
			dto.setProductNameKana(resultSet.getString("product_name_kana"));
			dto.setProductDescription(resultSet.getString("product_description"));
			dto.setCategoryId(resultSet.getInt("product_info.category_id"));
			dto.setCategoryName(resultSet.getString("category_name"));
			dto.setCategoryDescription(resultSet.getString("category_description"));
			dto.setPrice(resultSet.getInt("price"));
			dto.setImageFilePath(resultSet.getString("image_file_path"));
			dto.setImageFileName(resultSet.getString("image_file_name"));
			dto.setReleaseDate (resultSet.getString("release_date"));
			dto.setReleaseCompany(resultSet.getString("release_company"));
			list.add(dto);
		}
		return list;
	}

}
