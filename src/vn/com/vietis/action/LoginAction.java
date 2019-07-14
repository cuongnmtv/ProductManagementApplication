package vn.com.vietis.action;

import com.opensymphony.xwork2.ActionSupport;

import vn.com.vietis.dao.LoginDAO;
import vn.com.vietis.pojo.LoginInfo;

public class LoginAction extends ActionSupport {

	private String userName;
	private String password;

	public String execute() {
		String statusCode = "";
		boolean isUserValid = LoginDAO.isUserValid(new LoginInfo(userName, password));
		if (isUserValid) {
			statusCode = "success";
		} else {
			statusCode = "input";
		}
		return statusCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
