package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.dto.UserInfoDTO;
import com.internousdev.sukesyunshop.util.DBConnector;

public class MyPageDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public UserInfoDTO GoMyPageList(String userId) throws SQLException{
	//	DBConnector db = new DBConnector();
	//	Connection connection = db.getConnection();

		UserInfoDTO dto =new UserInfoDTO();
		String sql = "SELECT * FROM user_info WHERE user_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				dto.setUserId(rs.getString("user_id"));
				dto.setPassword(rs.getString("password"));
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setFamilyNameKana(rs.getString("family_name_kana"));
				dto.setFirstNameKana(rs.getString("first_name_kana"));
				dto.setSex(rs.getInt("sex"));
			    dto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public void deleteItemHistory (String userId) throws SQLException{
		String sql="DELETE FROM purchase_history_info "
				+ "Where user_id=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,userId);

		statement.executeUpdate();

	}

	//商品情報を購入履歴テーブルに持ってくる

	public ArrayList<CatalogDTO> getItemHistoryList(String userId) throws SQLException{
		ArrayList <CatalogDTO> itemHistoryList =new ArrayList<CatalogDTO>();

		String sql = ""
				+ "SELECT * "
				+ "FROM purchase_history_info "
				+ "INNER JOIN product_info "
				+ "ON purchase_history_info.product_id = product_info.product_id "
				+ "INNER JOIN m_category "
				+ "ON product_info.category_id = m_category.category_id "
				+ "WHERE user_id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,userId);
		ResultSet rs= statement.executeQuery();

		while(rs.next()){
			CatalogDTO dto = new CatalogDTO();
			dto.setId(rs.getInt("product_info.id"));
			dto.setProductId(rs.getInt("product_id"));
			dto.setProductName(rs.getString("product_name"));
			dto.setProductNameKana(rs.getString("product_name_kana"));
			dto.setProductDescription(rs.getString("product_description"));
			dto.setCategoryId(rs.getInt("product_info.category_id"));
			dto.setCategoryName(rs.getString("category_name"));
			dto.setCategoryDescription(rs.getString("category_description"));
			dto.setPrice(rs.getInt("price"));
			dto.setImageFilePath(rs.getString("image_file_path"));
			dto.setImageFileName(rs.getString("image_file_name"));
			dto.setReleaseDate (rs.getString("release_date"));
			dto.setReleaseCompany(rs.getString("release_company"));
			itemHistoryList.add(dto);
		}
		return itemHistoryList;
	}

}
