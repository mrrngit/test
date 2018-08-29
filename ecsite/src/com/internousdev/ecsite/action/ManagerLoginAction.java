package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.ManagerLoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.ManagerLoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerLoginAction extends ActionSupport implements SessionAware{
	private String loginManagerId;
	private String loginManagerPassword;
	private String result;
	private Map<String, Object> session;


	public String execute(){
		ManagerLoginDAO managerloginDAO = new ManagerLoginDAO();
		ManagerLoginDTO managerloginDTO = new ManagerLoginDTO();
		BuyItemDAO buyItemDAO = new BuyItemDAO();


	    result = ERROR;
		managerloginDTO = managerloginDAO.getLoginManagerInfo(loginManagerId, loginManagerPassword);
		session.put("loginUser", managerloginDTO);

		if(((ManagerLoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			session.put("login_user_id", managerloginDTO.getManagerLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			return result;
		}
		return result;
	}

	public String getLoginManagerId(){
		return loginManagerId;
	}
	public void setLoginManagerId(String loginManagerId){
		this.loginManagerId = loginManagerId;
	}

	public String getLoginManagerPassword(){
		return loginManagerPassword;
	}
	public void setLoginManagerPassword(String loginManagerPassword){
		this.loginManagerPassword = loginManagerPassword;
	}

	public Map<String,Object>getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}