package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sukesyunshop.dto.CartDTO;
import com.internousdev.sukesyunshop.util.DBConnector;

public class CartDAO {

	private DBConnector db =  new DBConnector();
	private Connection con = db.getConnection();

	//カートの中身を指定
	public ArrayList<CartDTO> getCartList(String userId, boolean loginFlag){
		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
		String sql;
		if(loginFlag){
			sql = ""
					+"SELECT *  "
					+"FROM cart_info "
					+"INNER JOIN product_info "
					+"ON cart_info.product_id = product_info.product_id "
					+"INNER JOIN m_category "
					+"ON product_info.category_id = m_category.category_id "
					+"WHERE user_id=?";
		}else{
			sql = ""
					+"SELECT *  "
					+"FROM cart_info "
					+"INNER JOIN product_info "
					+"ON cart_info.product_id = product_info.product_id "
					+"INNER JOIN m_category "
					+"ON product_info.category_id = m_category.category_id "
					+"WHERE temp_user_id=?";
		}
		try{
			PreparedStatement preparedStatement =  con.prepareStatement(sql);
			preparedStatement.setString(1,userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				CartDTO cartdto = new CartDTO();
				cartdto.setId(resultSet.getInt("product_info.id"));
				cartdto.setProductId(resultSet.getInt("product_id"));
				cartdto.setProductName(resultSet.getString("product_name"));
				cartdto.setProductNameKana(resultSet.getString("product_name_kana"));
				cartdto.setProductDescription(resultSet.getString("product_description"));
				cartdto.setCategoryId(resultSet.getInt("product_info.category_id"));
				cartdto.setCategoryName(resultSet.getString("category_name"));
				cartdto.setCategoryDescription(resultSet.getString("category_description"));
				cartdto.setPrice(resultSet.getInt("price"));
				cartdto.setImageFilePath(resultSet.getString("image_file_path"));
				cartdto.setImageFileName(resultSet.getString("image_file_name"));
				cartdto.setReleaseDate (resultSet.getString("release_date"));
				cartdto.setReleaseCompany(resultSet.getString("release_company"));
				cartList.add(cartdto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return cartList;
	}


//ログイン状態と仮ログイン状態の処理
	 public boolean addCart(String userId, int productId, boolean loginFlag){
		 String sql;
		if(loginFlag){
			sql=""
						+"INSERT INTO cart_info("
						+"user_id, product_id) "
						+ "VALUE( "
						+ "?,?)";
		}else{
			 sql=""
						+"INSERT INTO cart_info("
						+"temp_user_id, product_id) "
						+ "VALUE( "
						+ "?,?)";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,userId);
			preparedStatement.setInt(2,productId);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	 }


//CartDeleteAction  カートの中身を削除
	 public boolean deleteCart(String userId, int productId, boolean loginFlag){
		 String sql;
		if(loginFlag){
			sql=""
					+"DELETE FROM cart_info "
					+"WHERE user_id = ? "
					+ "AND product_id = ?";
		}else{
			sql=""
					+"DELETE FROM cart_info "
					+"WHERE temp_user_id = ?  "
					+ "AND product_id = ?";
		}

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,userId);
			preparedStatement.setInt(2,productId);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	 }

	 public boolean searchCart(String userId, int productId, boolean loginFlag) throws SQLException{
		 String sql;
		 if(loginFlag){
		 	sql = ""
		 		+ "SELECT *"
		 		+ "FROM cart_info "
		 		+ "WHERE user_id = ? "
		 		+ "AND product_id = ?";
		 }else{
			 sql=""
				+ "SELECT *"
				+ "FROM cart_info "
				+ "WHERE temp_user_id = ? "
				+ "AND product_id = ?";
		 }

		 PreparedStatement statement = con.prepareStatement(sql);
		 statement.setString(1, userId);
		 statement.setInt(2, productId);

		 ResultSet resultSet = statement.executeQuery();

		 return resultSet.next();
	 }

}

