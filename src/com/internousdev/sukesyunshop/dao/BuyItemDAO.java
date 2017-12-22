package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.util.DBConnector;
import com.internousdev.sukesyunshop.util.DateUtil;

public class BuyItemDAO {
	DBConnector connector = new DBConnector();
	Connection connection = connector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	// カート情報を参照
	public List<CatalogDTO> itemSelect() throws SQLException {
		List<CatalogDTO> CatalogDTOList = new ArrayList<CatalogDTO>();
		try {

			String sql = "SELECT * FROM" + " cart_info INNER JOIN product_info"
					+ " ON cart_info.product_id = product_info.product_id" + " WHERE product_id=?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
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
				CatalogDTOList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return CatalogDTOList;
	}

	// カート情報を購入履歴に追加
	public int itemInsert(List<Integer> list, String userId) throws SQLException {

		int insertCount = 0;

		String sql = "INSERT INTO purchase_history_info(user_id , product_id , insert_date , update_date)"
				+ " VALUES(?,?,?,?)";

		try {
			for (int i = 0; list.size() > i; i++) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setInt(2, list.get(i));
				ps.setString(3, dateUtil.getDate());
				ps.setString(4, dateUtil.getDate());

				insertCount = ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertCount;

	}

	// カート情報を削除
	public void itemDelete(String userId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM cart_info WHERE user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;

	}

}
