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

	//入れ所が分からないです。
	private DateUtil dateUtil = new DateUtil();


	//宛先のDTO
	public List<DestinationDTO> destDTOList = new ArrayList<DestinationDTO>();

	public List<DestinationDTO> DestinationSelect(){

		try{
			String sql = "SELECT * FROM"
					+ "destination_info INNER JOIN user_info"
					+ "ON destination_info.user_id = user_info.user_id"
					+ "WHERE user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();


			while(rs.next()){
				DestinationDTO dto = new DestinationDTO();
				dto.setUserId(rs.getString("user_id"));
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setFamilyNameKana(rs.getString("family_name_kana"));
				dto.setFirstNameKana(rs.getString("first_name_kana"));
				dto.setEmail(rs.getString("email"));
				dto.setTelNumber(rs.getString("tel_number"));



				destDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return destDTOList;
	}

}
