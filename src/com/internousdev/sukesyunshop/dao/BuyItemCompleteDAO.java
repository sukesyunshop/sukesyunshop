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

public class BuyItemCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "SELECT user_id, product_id FROM cart_info";

	public List<CatalogDTO> catalogDTOList = new ArrayList<CatalogDTO>();

	public List<CatalogDTO> select() {
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CatalogDTO dto = new CatalogDTO();
				dto.setId(rs.getInt("user_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setPrice(rs.getInt("price"));
				catalogDTOList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return catalogDTOList;
	}

	public int insert(String userId, int productId) {
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO purchase_history_info(user_id, product_id) VALUES(?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println(i + "商品履歴に登録されました。");
				ret = i;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public int delete() {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM cart_info WHERE user_id=? AND product_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//書き方がわかりません。


			 = ps.executeUpdate();

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
