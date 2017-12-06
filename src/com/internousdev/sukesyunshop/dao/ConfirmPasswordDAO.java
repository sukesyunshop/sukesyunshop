package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.sukesyunshop.dto.ConfirmPasswordDTO;
import com.internousdev.sukesyunshop.util.DBConnector;

public class ConfirmPasswordDAO  {



	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private ConfirmPasswordDTO confirmPasswordDTO=new ConfirmPasswordDTO();

	public boolean getLoginId(String loginId){



	String sql="SELECT * FROM user_info where login_id=?";

	try{
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, loginId);

		ResultSet resultSet=preparedStatement.executeQuery();

		return resultSet.next();

		}catch(Exception e){
			e.printStackTrace();
		}

		return false;
		}
	public ConfirmPasswordDTO getConfirmPasswordDTO() {
		return confirmPasswordDTO;
	}
	}

