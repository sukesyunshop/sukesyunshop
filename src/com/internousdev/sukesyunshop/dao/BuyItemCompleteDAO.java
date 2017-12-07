package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sukesyunshop.dto.BuyItemDTO;
import com.internousdev.sukesyunshop.util.DBConnector;
import com.internousdev.sukesyunshop.util.DateUtil;

public class BuyItemCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	private DateUtil dateUtil = new DateUtil();

	//アイテム情報のDTO
	public List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	//カート情報を参照
	public List<BuyItemDTO> itemSelect() {
		try {

			String sql = "SELECT * FROM"
	                  + " cart_info INNER JOIN product_info"
			          + " ON cart_info.product_id = product_info.product_id"
	                  + " WHERE product_id=?";

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
				dto.setReleaseDate(rs.getString("release_date"));
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

	//カート情報を購入履歴に追加
	public void itemInsert(BuyItemDTO dto) throws SQLException {


		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO purchase_history_info(user_id , product_id , insert_date , update_date)"
				+ " VALUES(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getUserId());
			ps.setInt(2, dto.getItemId());
			ps.setString(3,dateUtil.getDate());
			ps.setString(4,dateUtil.getDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

    //カート情報を削除
	public void itemDelete(int itemId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM cart_info WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);

			 ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ;

	}

}
