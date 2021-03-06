package com.internousdev.sukesyunshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sukesyunshop.dto.DestinationDTO;
import com.internousdev.sukesyunshop.util.DBConnector;
import com.internousdev.sukesyunshop.util.DateUtil;

public class DestinationDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	private DateUtil dateUtil = new DateUtil();

	// 宛先のDTO
	public List<DestinationDTO> destDTOList = new ArrayList<DestinationDTO>();

	// 宛先の情報を参照メゾット
	public List<DestinationDTO> destSelect(String userId) throws SQLException {

		String sql = "SELECT * FROM destination_info WHERE user_id=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			DestinationDTO dto = new DestinationDTO();
			dto.setUserId(rs.getString("user_id"));
			dto.setFamilyName(rs.getString("family_name"));
			dto.setFirstName(rs.getString("first_name"));
			dto.setFamilyNameKana(rs.getString("family_name_kana"));
			dto.setFirstNameKana(rs.getString("first_name_kana"));
			dto.setEmail(rs.getString("email"));
			dto.setTelNumber(rs.getString("tel_number"));
			dto.setUserAddress(rs.getString("user_address"));

			destDTOList.add(dto);
		}

		return destDTOList;
	}
	/*
	 * 宛先情報をDestintionTABLEに更新
	 */

	public int destInsert(DestinationDTO dto) throws SQLException {

		int insertCount = 0;

		String sql = "INSERT INTO destination_info(user_id,family_name, "
				+ "first_name, family_name_kana, first_name_kana, sex,"
				+ "email,tel_number,user_address , insert_date , update_date) " + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, dto.getUserId());
		ps.setString(2, dto.getFamilyName());
		ps.setString(3, dto.getFirstName());
		ps.setString(4, dto.getFamilyNameKana());
		ps.setString(5, dto.getFirstNameKana());
		ps.setInt(6, dto.getSex());
		ps.setString(7, dto.getEmail());
		ps.setString(8, dto.getTelNumber());
		ps.setString(9, dto.getUserAddress());
		ps.setString(10, dateUtil.getDate());
		ps.setString(11, dateUtil.getDate());

		insertCount = ps.executeUpdate();

		return insertCount;
	}

	public boolean existDest(DestinationDTO dto) throws SQLException {
		String sql = "" + "SELECT * " + "FROM destination_info " + "WHERE user_id = ? " + "AND family_name = ? "
				+ "AND first_name =? " + "AND family_name_kana = ? " + "AND first_name_kana = ? " + "AND sex = ? "
				+ "AND email = ? " + "AND tel_number = ? " + "AND user_address = ? ";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, dto.getUserId());
		ps.setString(2, dto.getFamilyName());
		ps.setString(3, dto.getFirstName());
		ps.setString(4, dto.getFamilyNameKana());
		ps.setString(5, dto.getFirstNameKana());
		ps.setInt(6, dto.getSex());
		ps.setString(7, dto.getEmail());
		ps.setString(8, dto.getTelNumber());
		ps.setString(9, dto.getUserAddress());

		ResultSet resultSet = ps.executeQuery();
		return resultSet.next();
	}
}
