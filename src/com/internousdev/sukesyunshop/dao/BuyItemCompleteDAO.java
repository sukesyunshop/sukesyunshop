package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sukesyunshop.dto.BuyItemDTO;
import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.util.DBConnector;
import com.internousdev.sukesyunshop.util.DateUtil;

public class BuyItemCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "SELECT * FROM"
	                  + " cart_info INNER JOIN product_info"
			          + " ON product_info.product_id=cart_info.product_id"
	                  + " WHERE product_id=?";

	public List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	public List<BuyItemDTO> select() {
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BuyItemDTO dto = new BuyItemDTO();
				dto.setItemId(rs.getInt("productId"));
				dto.setItemName(rs.getString("product_name"));
				dto.setItemNameKana(rs.getString("product_name_kana"));
				dto.setItemDescription(rs.getString("prodcut_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getString("release_date")); // データ型が？
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				buyItemDTOList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return buyItemDTOList;
	}

	public int insert(BuyItemDTO dto) {
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
		//上と同じく書き方が分からない。
		return;
	}

}
