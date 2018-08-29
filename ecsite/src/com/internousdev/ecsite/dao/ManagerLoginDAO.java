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

		public ManagerLoginDTO getLoginManagerInfo(String loginManagerId,String loginManagerPassword){

		String sql = "SELECT * FROM login_manager_transaction where manager_login_id =? AND manager_login_pass =?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginManagerId);
			preparedStatement.setString(2, loginManagerPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){

				managerloginDTO.setManagerLoginId(resultSet.getString("manager_login_id"));
				managerloginDTO.setManagerLoginPassword(resultSet.getString("manager_login_pass"));
				managerloginDTO.setManagerName(resultSet.getString("manager_name"));


				if(!(resultSet.getString("manager_login_id").equals(null))){
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
