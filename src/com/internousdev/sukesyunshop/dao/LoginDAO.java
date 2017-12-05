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

		String sql = ""
				+ "SELECT logined "
				+ "FROM user_info "
				+ "WHERE user_id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userId);

		ResultSet resultSet = statement.executeQuery();

		connection.close();

		return resultSet.next();
	}

	public boolean checkIdPass(String userId, String password) throws SQLException{

		String sql = ""
				+ "SELECT logined "
				+ "FROM user_info "
				+ "WHERE user_id = ? "
				+ "AND password = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userId);
		statement.setString(2, password);

		ResultSet resultSet = statement.executeQuery();

		connection.close();

		return resultSet.next();

	}

	public boolean login(String userId, String password) throws SQLException{

		if(!checkIdPass(userId, password)){
			return false;
		}

		String sql = ""
				+ "UPDATE user_info "
				+ "SET logined = 1 "
				+ "WHERE user_id = ? "
				+ "AND password = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userId);
		statement.setString(2, password);

		ResultSet resultSet = statement.executeQuery();

		connection.close();

		return resultSet.next();
	}

}
