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


	//TODO いらなそうなメソッドをコメントアウトしています。
	//productdetail.jspにcatalog.jspで指定した値(商品のID)を送る
	/*public CartDTO getId(int productId){
		CartDTO dto = new CartDTO();
		String sql=""
				+"SELECT id"
				+"FROM product_info "
				+"INNER JOIN m_category "
				+"ON product_info.category_id = m_category.category_id "
				+"WHERE product_id=?";

		try{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,productId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				dto.setId(resultSet.getInt("product_info.id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductNameKana(resultSet.getString("product_name_kana"));
				dto.setProductDescription(resultSet.getString("product_description"));
				dto.setCategory(resultSet.getString("category_name"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReleaseDate (resultSet.getString("release_date"));
				dto.setReleaseCompany(resultSet.getString("release_company"));
			}
			} catch(Exception e){
				e.printStackTrace();
			}
			return dto;
	}*/


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

}

