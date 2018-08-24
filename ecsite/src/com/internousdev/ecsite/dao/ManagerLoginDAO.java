package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.ManagerLoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ManagerLoginDAO {


		private DBConnector dbConnector = new DBConnector();
		private Connection connection = dbConnector.getConnection();
		private ManagerLoginDTO managerloginDTO= new ManagerLoginDTO();

		public ManagerLoginDTO getLoginUserInfo(String loginName,String loginPassword){

		String sql = "SELECT * FROM login_manager_transaction where user_name =? AND login_pass =?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginName);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){

				managerloginDTO.setUserName(resultSet.getString("user_name"));
				managerloginDTO.setLoginPassword(resultSet.getString("login_pass"));


				if(!(resultSet.getString("login_id").equals(null))){
					managerloginDTO.setLoginFlg(true);
				}

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return managerloginDTO;
	}
		public ManagerLoginDTO getManagerLoginDTO(){
			return managerloginDTO;
		}
}
