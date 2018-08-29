package com.internousdev.ecsite.dto;

public class ManagerLoginDTO {
	private String managerloginId;
	private String managerloginPassword;
	private String managerName;
	private boolean loginFlg = false;

	public String getManagerLoginId(){
		return managerloginId;
	}
	public void setManagerLoginId(String managerloginId){
		this.managerloginId = managerloginId;
	}

	public String getManagerLoginPassword(){
		return managerloginPassword;
	}
	public void setManagerLoginPassword(String managerloginPassword){
		this.managerloginPassword = managerloginPassword;
	}

	public String getManagerName(){
		return managerName;
	}
	public void setManagerName(String managerName){
		this.managerName = managerName;
	}

	public boolean getLoginFlg(){
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg = loginFlg;
	}
}
