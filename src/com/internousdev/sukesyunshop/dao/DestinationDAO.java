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

//宛先の情報を参照メゾット
	public List<DestinationDTO> destSelect(String userId) {

		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destDTOList;
	}
	/*
	 * 宛先情報をDestintionTABLEに更新
	 */

	public  void destInsert(DestinationDTO dto) throws SQLException {

		String sql = "INSERT INTO destintion_info(user_id,family_name, "
				+ "first_name, family_name_kana, first_name_kana,"
				+ "email,tel_number,user_address , insert_date , update_date) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dto.getUserId());
			ps.setString(2, dto.getFamilyName());
			ps.setString(3, dto.getFirstName());
			ps.setString(4, dto.getFamilyNameKana());
			ps.setString(5, dto.getFirstNameKana());
			ps.setString(6, dto.getEmail());
			ps.setString(7, dto.getTelNumber());
			ps.setString(8, dto.getUserAddress());
			ps.setString(9, dateUtil.getDate());
			ps.setString(10, dateUtil.getDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	}
