package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.sukesyunshop.util.DBConnector;

public class TempBuyItemConfirmDAPO {

	DBConnector connector = new DBConnector();
	Connection connection = connector.getConnection();

	public void convertId(String userId, String tempUserId) throws SQLException{
		String sql = ""
				+ "UPDATE cart_info "
				+ "SET user_id = ? "
				+ "WHERE temp_user_id = ? ";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userId);
		statement.setString(2, tempUserId);
		statement.executeUpdate();
	}

}
