package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.util.DBConnector;

public class CatalogDAO {

	private DBConnector dbConnector = new DBConnector();
	private  Connection connection = dbConnector.getConnection();



	public CatalogDTO getItem(int productId){
		CatalogDTO getItem=new CatalogDTO();
		String sql=""
				+ "SELECT  * "
				+ "FROM product_info "
				+ "INNER JOIN m_category "
				+ "ON product_info.category_id = m_category.category_id "
				+ "where product_id = ?";

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, productId);
				ResultSet resultSet = preparedStatement.executeQuery();

				if(resultSet.next()){
					getItem.setId(resultSet.getInt("product_info.id"));
					getItem.setProductId(resultSet.getInt("product_id"));
					getItem.setProductName(resultSet.getString("product_name"));
					getItem.setProductNameKana(resultSet.getString("product_name_kana"));
					getItem.setProductDescription(resultSet.getString("product_description"));
					getItem.setCategoryId(resultSet.getInt("product_info.category_id"));
					getItem.setCategoryName(resultSet.getString("category_name"));
					getItem.setCategoryDescription(resultSet.getString("category_description"));
					getItem.setPrice(resultSet.getInt("price"));
					getItem.setImageFilePath(resultSet.getString("image_file_path"));
					getItem.setImageFileName(resultSet.getString("image_file_name"));
					getItem.setReleaseDate (resultSet.getString("release_date"));
					getItem.setReleaseCompany(resultSet.getString("release_company"));
				}
			} catch(Exception e){
				e.printStackTrace();
			}
				return getItem;
	}


//商品一覧の中身,productail,cart,seachに値を渡している
	public ArrayList<CatalogDTO> getCatalogList(int page) throws SQLException{
		ArrayList<CatalogDTO> list = new ArrayList<CatalogDTO>();
		String sql = ""
				+ "SELECT  * "
				+ "FROM product_info "
				+ "INNER JOIN m_category "
				+ "ON product_info.category_id = m_category.category_id "
				+ "LIMIT ?, ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, (page-1)*9);
		preparedStatement.setInt(2, 9);
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()){
			CatalogDTO catalogDto = new CatalogDTO();
			catalogDto.setId(resultSet.getInt("product_info.id"));
			catalogDto.setProductId(resultSet.getInt("product_id"));
			catalogDto.setProductName(resultSet.getString("product_name"));
			catalogDto.setProductNameKana(resultSet.getString("product_name_kana"));
			catalogDto.setProductDescription(resultSet.getString("product_description"));
			catalogDto.setCategoryId(resultSet.getInt("product_info.category_id"));
			catalogDto.setCategoryName(resultSet.getString("category_name"));
			catalogDto.setCategoryDescription(resultSet.getString("category_description"));
			catalogDto.setPrice(resultSet.getInt("price"));
			catalogDto.setImageFilePath(resultSet.getString("image_file_path"));
			catalogDto.setImageFileName(resultSet.getString("image_file_name"));
			catalogDto.setReleaseDate (resultSet.getString("release_date"));
			catalogDto.setReleaseCompany(resultSet.getString("release_company"));
			list.add(catalogDto);
		}
		return list;
	}


//商品詳細にて同じカテゴリーのアイテム表示
	public ArrayList<CatalogDTO> miniList(int categoryId, int removeId) throws SQLException{
		ArrayList<CatalogDTO> miniList = new ArrayList<CatalogDTO>();
		String sql = ""
				+ "SELECT * "
				+ "FROM product_info "
				+ "INNER JOIN m_category "
				+ "ON product_info.category_id = m_category.category_id "
				+ "WHERE product_info.category_id=? "
				+ "AND product_info.id != ? "
				+ "LIMIT 4 ";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, categoryId);
		preparedStatement.setInt(2, removeId);
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()){

			CatalogDTO sub = new CatalogDTO();
			sub.setId(resultSet.getInt("product_info.id"));
			sub.setProductId(resultSet.getInt("product_id"));
			sub.setProductName(resultSet.getString("product_name"));
			sub.setProductNameKana(resultSet.getString("product_name_kana"));
			sub.setProductDescription(resultSet.getString("product_description"));
			sub.setCategoryId(resultSet.getInt("product_info.category_id"));
			sub.setCategoryName(resultSet.getString("category_name"));
			sub.setCategoryDescription(resultSet.getString("category_description"));
			sub.setPrice(resultSet.getInt("price"));
			sub.setImageFilePath(resultSet.getString("image_file_path"));
			sub.setImageFileName(resultSet.getString("image_file_name"));
			sub.setReleaseDate (resultSet.getString("release_date"));
			sub.setReleaseCompany(resultSet.getString("release_company"));
			miniList.add(sub);
		}
		return miniList;
	}

	public int getCatalogCount() throws SQLException{
		String sql = ""
				+ "SELECT count(*) "
				+ "FROM product_info ";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			return resultSet.getInt("count(*)");
		}
		return 0;
	}

	public ArrayList<CatalogDTO> getRandomItem() throws SQLException{
		ArrayList<CatalogDTO> list = new ArrayList<>();
		String sql = ""
				+ "SELECT * "
				+ "FROM product_info "
				+ "INNER JOIN m_category "
				+ "ON product_info.category_id = m_category.category_id "
				+ "ORDER BY RAND() "
				+ "LIMIT 10 ";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

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

