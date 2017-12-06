package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.sukesyunshop.dto.CatalogDTO;
import com.internousdev.sukesyunshop.util.DBConnector;

public class CatalogDAO {

	private DBConnector dbConnector = new DBConnector();
	private  Connection connection = dbConnector.getConnection();


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
				catalogdto.setPrice(resultSet.getString("price"));
				list.add(catalogdto);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}



}

