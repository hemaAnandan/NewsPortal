package com.newsportal.demo.model;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

public class Userinformationmodel {
	
	int userId;
	String userName;
	String userEmail;
	String password;
	String languageChoice;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLanguageChoice() {
		return languageChoice;
	}
	public void setLanguageChoice(String languageChoice) {
		this.languageChoice = languageChoice;
	}
}


