package com.internousdev.ecsite.dao;
import java.sql.Connection;

import com.internousdev.ecsite.dto.ManagerLoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ManagerLoginDAO {
	public ManagerLoginDTO getLoginUserInfo(String loginUserId,String loginPassword){

		com.internousdev.ecsite.util.DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ManagerLoginDTO managerloginDTO = new ManagerLoginDTO();
		String sql = "SELECT * FROM login_user_transaction where login_id =? AND login_pass =?";
	}
}
