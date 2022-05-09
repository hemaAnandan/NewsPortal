package com.newsportal.demo.model;


/**
 * 
 * @author Hemamalini
 *
 */

public class Newsfeedinformationmodel {
	
	int adminId;
	String FrequentNewsUpdates;
	String breakingNews;
	String PopularNews;
	String MostReadTopics;
	String autoRefresh;
	String NewspaperChoice;
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getFrequentNewsUpdates() {
		return FrequentNewsUpdates;
	}
	public void setFrequentNewsUpdates(String frequentNewsUpdates) {
		FrequentNewsUpdates = frequentNewsUpdates;
	}
	public String getBreakingNews() {
		return breakingNews;
	}
	public void setBreakingNews(String breakingNews) {
		this.breakingNews = breakingNews;
	}
	public String getPopularNews() {
		return PopularNews;
	}
	public void setPopularNews(String popularNews) {
		PopularNews = popularNews;
	}
	public String getMostReadTopics() {
		return MostReadTopics;
	}
	public void setMostReadTopics(String mostReadTopics) {
		MostReadTopics = mostReadTopics;
	}
	public String getAutoRefresh() {
		return autoRefresh;
	}
	public void setAutoRefresh(String autoRefresh) {
		this.autoRefresh = autoRefresh;
	}
	public String getNewspaperChoice() {
		return NewspaperChoice;
	}
	public void setNewspaperChoice(String newspaperChoice) {
		NewspaperChoice = newspaperChoice;
	}
}

