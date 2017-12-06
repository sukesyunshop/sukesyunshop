package com.internousdev.sukesyunshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.internousdev.sukesyunshop.util.DBConnector;

public class CompletePasswordDAO {


	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();



	public boolean updatePassword(String loginPassword,String loginId){
		String sql="UPDATE user_info SET password =? where user_id= ?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginPassword);
			preparedStatement.setString(2,loginId);

			preparedStatement.executeUpdate();
			return true;

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	}


