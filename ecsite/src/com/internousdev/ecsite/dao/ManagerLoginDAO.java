package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.ManagerLoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ManagerLoginDAO {
	public ManagerLoginDTO getLoginUserInfo(String loginUserId,String loginPassword){

		com.internousdev.ecsite.util.DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ManagerLoginDTO managerloginDTO = new ManagerLoginDTO();
		String sql = "SELECT * FROM login_user_transaction where login_id =? AND login_pass =?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				managerloginDTO.setLoginId(resultSet.getString("login_id"));
				managerloginDTO.setLoginPassword(resultSet.getString("login_pass"));
				managerloginDTO.setUserName(resultSet.getString("user_name"));

				if(!(resultSet.getString("login_id").equals(null))){
					managerloginDTO.setLoginFlg(true);
				}

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return managerloginDTO;
	}
}
