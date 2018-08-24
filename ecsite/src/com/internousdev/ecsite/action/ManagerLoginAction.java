package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ManagerLoginDAO;
import com.internousdev.ecsite.dto.ManagerLoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerLoginAction extends ActionSupport implements SessionAware{

	private String loginUserId2;
	private String loginPassword2;
	public Map<String, Object>session;
	private ManagerLoginDAO managerloginDAO = new ManagerLoginDAO();
	private ManagerLoginDTO managerloginDTO = new ManagerLoginDTO();

	public String execute() throws SQLException{
		String ret=ERROR;
		ManagerLoginDAO dao=new ManagerLoginDAO();
		ManagerLoginDTO dto=new ManagerLoginDTO();

		dto=dao.login_manager_transaction(name,password);
		if(name.equals(dto.getName())){
			if(password.equals(dto.getLoginPassword())){
				ret=SUCCESS;
			}
		}
	return ret;
}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
}