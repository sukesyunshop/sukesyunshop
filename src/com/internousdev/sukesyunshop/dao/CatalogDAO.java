package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.play.dto.CatalogDTO;
import com.internousdev.play.util.DBConnector;

public class CatalogDAO {

	private DBConnector dbConnector = new DBConnector();
	private  Connection connection = dbConnector.getConnection();

	public CatalogDTO getItem(int productId){
		CatalogDTO getItem=new CatalogDTO();
		String sql=""
				+ "SELECT  id, product_name,product_name_kana, price,release_date datetime,release_company "
				+ " FROM product_info "
				+ "where product_id=?";

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, productId);
				ResultSet resultSet = preparedStatement.executeQuery();

				if(resultSet.next()){
					getItem.setId(resultSet.getInt("id"));
					getItem.setProductName(resultSet.getString("product_name"));
					getItem.setProductNameKana(resultSet.getString("product_name_kana"));
					getItem.setPrice(resultSet.getInt("price"));
					getItem.setRelease_date (resultSet.getInt("release_date"));
					getItem.setRelease_company(resultSet.getString("release_company"));
					System.out.println(getItem.getProductName());
				}
			} catch(Exception e){
				e.printStackTrace();
			}
			return getItem;
		}

	public ArrayList<CatalogDTO> getCatalogList(){
		ArrayList<CatalogDTO> list = new ArrayList<CatalogDTO>();
		String sql = "SELECT  id, product_name,product_name_kana, price FROM product_info ";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				CatalogDTO catalogdto = new CatalogDTO();
				catalogdto.setId(resultSet.getInt("id"));
				catalogdto.setProductName(resultSet.getString("product_name"));
				System.out.println(catalogdto.getProductName());
				catalogdto.setProductNameKana(resultSet.getString("product_name_kana"));
				catalogdto.setPrice(resultSet.getInt("price"));
				list.add(catalogdto);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}



}

