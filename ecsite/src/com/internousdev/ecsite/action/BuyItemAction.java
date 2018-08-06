package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	private int stock;
	private String pay;
	private String buyItem_name;
	private String buyItem_price;
	private String count;
	public Map<String, Object> session; private String result;
	public String execute() { result = SUCCESS;

	session.put("count", count);
	session.put("stock", count);
	int intStock = Integer.parseInt(session.get("stock").toString());
	int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
	session.put("total_price", intStock * intPrice);
	String payment;

	if(pay.equals("1")) {
		payment = "現金払い";
		session.put("pay", payment);
	}else {
		payment = "クレジットカード";
		session.put("pay", payment);
	}
    return result;
}
  public int getStock() {
	  return stock;
  }
  public void setStock(int stock) {
	  this.stock = stock;
  }

  public String getPay() {
	  return pay;
  }
  public void setPay(String pay) {
	  this.pay = pay;
  }

  public Map<String,Object>getSession(){
	  return session;
  }

  @Override
  public void setSession(Map<String,Object>session) {
	  this.session = session;
  }
public String getBuyItem_name() {
	return buyItem_name;
}
public void setBuyItem_name(String buyItem_name) {
	this.buyItem_name = buyItem_name;
}
public String getBuyItem_price() {
	return buyItem_price;
}
public void setBuyItem_price(String buyItem_price) {
	this.buyItem_price = buyItem_price;
}
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}


}