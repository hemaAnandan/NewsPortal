package com.newsportal.demo.model;


/**
 * 
 * @author Hemamalini
 *
 */

public class Historymodel {
	
	int adminId;
	String loginStatus;
	String currentNews;
	String frequentNewsUpdate;
	String worldNews;
	String Sports;
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getCurrentNews() {
		return currentNews;
	}
	public void setCurrentNews(String currentNews) {
		this.currentNews = currentNews;
	}
	public String getFrequentNewsUpdate() {
		return frequentNewsUpdate;
	}
	public void setFrequentNewsUpdate(String frequentNewsUpdate) {
		this.frequentNewsUpdate = frequentNewsUpdate;
	}
	public String getWorldNews() {
		return worldNews;
	}
	public void setWorldNews(String worldNews) {
		this.worldNews = worldNews;
	}
	public String getSports() {
		return Sports;
	}
	public void setSports(String sports) {
		Sports = sports;
	}
}

