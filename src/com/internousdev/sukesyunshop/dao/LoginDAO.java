package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.sukesyunshop.util.DBConnector;

public class LoginDAO {

	private DBConnector connector = new DBConnector();
	private Connection connection = connector.getConnection();

	public boolean isLogin(String userId) throws SQLException{
		boolean result;

		String sql = ""
				+ "SELECT logined "
				+ "FROM user_info "
				+ "WHERE user_id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userId);

		ResultSet resultSet = statement.executeQuery();

		result = resultSet.next();

		connection.close();

		return result;
	}

}
